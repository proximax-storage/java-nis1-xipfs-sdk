/*
 * 
 */
package io.nem.xpx.facade;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.nem.core.crypto.CryptoEngine;
import org.nem.core.crypto.CryptoEngines;
import org.nem.core.crypto.KeyPair;
import org.nem.core.crypto.PrivateKey;
import org.nem.core.crypto.PublicKey;
import org.nem.core.model.Account;
import org.nem.core.model.Address;
import org.nem.core.model.MessageTypes;
import org.nem.core.model.mosaic.Mosaic;
import org.nem.core.model.ncc.NemAnnounceResult;
import org.nem.core.model.primitive.Amount;
import org.nem.core.utils.HexEncoder;
import io.nem.ApiException;
import io.nem.xpx.DataHashApiInterface;
import io.nem.xpx.LocalDataHashApi;
import io.nem.xpx.RemoteDataHashApi;
import io.nem.xpx.TransactionAndAnnounceApi;
import io.nem.xpx.builder.BinaryTransferTransactionBuilder;
import io.nem.xpx.facade.connection.PeerConnection;
import io.nem.xpx.facade.connection.RemotePeerConnection;
import io.nem.xpx.facade.model.UploadData;
import io.nem.xpx.model.BinaryTransactionEncryptedMessage;
import io.nem.xpx.model.PeerConnectionNotFoundException;
import io.nem.xpx.model.RequestAnnounceDataSignature;
import io.nem.xpx.model.UploadDataParameter;
import io.nem.xpx.model.UploadException;
import io.nem.xpx.model.UploadFileParameter;
import io.nem.xpx.model.UploadPathParameter;
import io.nem.xpx.utils.JsonUtils;


/**
 * The Class Upload.
 */
public class Upload {

	/** The peer connection. */
	private PeerConnection peerConnection;

	/** The engine. */
	private CryptoEngine engine;

	/** The data hash api. */
	private DataHashApiInterface dataHashApi;

	/** The publish and announce api. */
	private TransactionAndAnnounceApi transactionAndAnnounceApi;

	/** The is local peer connection. */
	private boolean isLocalPeerConnection = false;

	/**
	 * Instantiates a new upload.
	 */
	public Upload() {
	}

	/**
	 * Instantiates a new upload.
	 *
	 * @param peerConnection            the peer connection
	 * @throws PeerConnectionNotFoundException the peer connection not found exception
	 */
	public Upload(PeerConnection peerConnection) throws PeerConnectionNotFoundException {
		if (peerConnection == null) {
			throw new PeerConnectionNotFoundException("PeerConnection can't be null");
		}

		if (peerConnection instanceof RemotePeerConnection) {
			this.dataHashApi = new RemoteDataHashApi();
		} else {
			this.isLocalPeerConnection = true;
			this.dataHashApi = new LocalDataHashApi();
		}

		this.peerConnection = peerConnection;
		this.engine = CryptoEngines.ed25519Engine();
		this.transactionAndAnnounceApi = new TransactionAndAnnounceApi();
	}

	/**
	 * Upload file.
	 *
	 * @param uploadParameter the upload parameter
	 * @return the upload data
	 * @throws UploadException the upload exception
	 * @throws IOException             Signals that an I/O exception has occurred.
	 * @throws ApiException             the api exception
	 */
	public UploadData uploadFile(UploadFileParameter uploadParameter)
			throws UploadException, IOException, ApiException {
		UploadData uploadData = handleFileUpload(uploadParameter);
		return uploadData;

	}

	/**
	 * Upload data.
	 *
	 * @param uploadParameter the upload parameter
	 * @return the upload data
	 * @throws UploadException the upload exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ApiException             the api exception
	 */
	public UploadData uploadData(UploadDataParameter uploadParameter)
			throws UploadException, IOException, ApiException {
		UploadData uploadData = handleDataUpload(uploadParameter);
		return uploadData;
	}

	/**
	 * Upload path.
	 *
	 * @param uploadParameter the upload parameter
	 * @return the upload data
	 * @throws UploadException the upload exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ApiException the api exception
	 * @throws PeerConnectionNotFoundException the peer connection not found exception
	 */
	public UploadData uploadPath(UploadPathParameter uploadParameter)
			throws UploadException, IOException, ApiException, PeerConnectionNotFoundException {
		UploadData uploadData = handlePathUpload(uploadParameter);
		return uploadData;
	}

	/**
	 * Handle data upload.
	 *
	 * @param uploadParameter the upload parameter
	 * @return the upload data
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ApiException the api exception
	 * @throws UploadException the upload exception
	 */
	private UploadData handleDataUpload(UploadDataParameter uploadParameter)
			throws IOException, ApiException, UploadException {
		String publishedData = "";
		if (uploadParameter.getMosaics() == null) {
			uploadParameter.setMosaics(new Mosaic[0]);
		}

		UploadData uploadData = new UploadData();
		byte[] encrypted = null;
		BinaryTransactionEncryptedMessage response = null;
		try {
			if (uploadParameter.getMessageType() == MessageTypes.SECURE) {
				encrypted = engine
						.createBlockCipher(
								new KeyPair(PrivateKey.fromHexString(uploadParameter.getSenderPrivateKey()), engine),
								new KeyPair(PublicKey.fromHexString(uploadParameter.getRecipientPublicKey()), engine))
						.encrypt(uploadParameter.getData().getBytes());

				String encryptedData = HexEncoder.getString(encrypted);
				response = dataHashApi.generateHashAndExposeDataToNetworkUsingPOST(encryptedData,
						uploadParameter.getName(), uploadParameter.getKeywords(), uploadParameter.getMetaData());
			} else { // PLAIN
				response = dataHashApi.generateHashAndExposeDataToNetworkUsingPOST(uploadParameter.getData(),
						uploadParameter.getName(), uploadParameter.getKeywords(), uploadParameter.getMetaData());
			}

			if (this.isLocalPeerConnection) {
				// Announce The Signature
				NemAnnounceResult announceResult = BinaryTransferTransactionBuilder
						.sender(new Account(
								new KeyPair(PrivateKey.fromHexString(uploadParameter.getSenderPrivateKey()))))
						.recipient(new Account(Address
								.fromPublicKey(PublicKey.fromHexString(uploadParameter.getRecipientPublicKey()))))
						.version(2).amount(Amount.fromNem(1l))
						.message(JsonUtils.toJson(response), uploadParameter.getMessageType())
						.addMosaics(uploadParameter.getMosaics()).buildSignAndSendTransaction();
				publishedData = announceResult.getTransactionHash().toString();

			} else {
				// Announce The Signature
				RequestAnnounceDataSignature requestAnnounceDataSignature = BinaryTransferTransactionBuilder
						.sender(new Account(
								new KeyPair(PrivateKey.fromHexString(uploadParameter.getSenderPrivateKey()))))
						.recipient(new Account(Address
								.fromPublicKey(PublicKey.fromHexString(uploadParameter.getRecipientPublicKey()))))
						.version(2).amount(Amount.fromNem(1l))
						.message(JsonUtils.toJson(response), uploadParameter.getMessageType())
						.addMosaics(uploadParameter.getMosaics()).buildAndSignTransaction();

				// Return the NEM Txn Hash
				publishedData = transactionAndAnnounceApi
						.announceRequestPublishDataSignatureUsingPOST(requestAnnounceDataSignature);
			}

			uploadData.setDataMessage(response);
			uploadData.setNemHash(publishedData);
		} catch (Exception e) {
			dataHashApi.cleanupPinnedContentUsingPOST(response.getHash());
			throw new UploadException(e);
		}
		return uploadData;
	}

	/**
	 * Handle file upload.
	 *
	 * @param uploadParameter the upload parameter
	 * @return the upload data
	 * @throws UploadException the upload exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ApiException the api exception
	 */
	private UploadData handleFileUpload(UploadFileParameter uploadParameter)
			throws UploadException, IOException, ApiException {
		String publishedData = "";
		if (uploadParameter.getMosaics() == null) {
			uploadParameter.setMosaics(new Mosaic[0]);
		}

		UploadData uploadData = new UploadData();
		byte[] encrypted = null;
		BinaryTransactionEncryptedMessage response = null;
		try {
			if (uploadParameter.getMessageType() == MessageTypes.SECURE) {
				encrypted = engine
						.createBlockCipher(
								new KeyPair(PrivateKey.fromHexString(uploadParameter.getSenderPrivateKey()), engine),
								new KeyPair(PublicKey.fromHexString(uploadParameter.getRecipientPublicKey()), engine))
						.encrypt(FileUtils.readFileToByteArray(uploadParameter.getData()));

				String data = HexEncoder.getString(encrypted);
				response = dataHashApi.generateHashAndExposeDataToNetworkUsingPOST(data,
						uploadParameter.getData().getName(), uploadParameter.getKeywords(),
						uploadParameter.getMetaData());
			} else { // PLAIN
				String data = HexEncoder.getString(FileUtils.readFileToByteArray(uploadParameter.getData()));
				response = dataHashApi.generateHashAndExposeDataToNetworkUsingPOST(data,
						uploadParameter.getData().getName(), uploadParameter.getKeywords(),
						uploadParameter.getMetaData());
			}

			if (this.isLocalPeerConnection) {
				// Announce The Signature
				NemAnnounceResult announceResult = BinaryTransferTransactionBuilder
						.sender(new Account(
								new KeyPair(PrivateKey.fromHexString(uploadParameter.getSenderPrivateKey()))))
						.recipient(new Account(Address
								.fromPublicKey(PublicKey.fromHexString(uploadParameter.getRecipientPublicKey()))))
						.version(2).amount(Amount.fromNem(1l))
						.message(JsonUtils.toJson(response), uploadParameter.getMessageType())
						.addMosaics(uploadParameter.getMosaics()).buildSignAndSendTransaction();
				publishedData = announceResult.getTransactionHash().toString();

			} else {
				// Announce The Signature
				RequestAnnounceDataSignature requestAnnounceDataSignature = BinaryTransferTransactionBuilder
						.sender(new Account(
								new KeyPair(PrivateKey.fromHexString(uploadParameter.getSenderPrivateKey()))))
						.recipient(new Account(Address
								.fromPublicKey(PublicKey.fromHexString(uploadParameter.getRecipientPublicKey()))))
						.version(2).amount(Amount.fromNem(1l))
						.message(JsonUtils.toJson(response), uploadParameter.getMessageType())
						.addMosaics(uploadParameter.getMosaics()).buildAndSignTransaction();

				// Return the NEM Txn Hash
				publishedData = transactionAndAnnounceApi
						.announceRequestPublishDataSignatureUsingPOST(requestAnnounceDataSignature);
			}
			uploadData.setDataMessage(response);
			uploadData.setNemHash(publishedData);
		} catch (Exception e) {
			dataHashApi.cleanupPinnedContentUsingPOST(response.getHash());
			throw new UploadException(e);
		}
		return uploadData;
	}

	/**
	 * Handle path upload.
	 *
	 * @param uploadParameter the upload parameter
	 * @return the upload data
	 * @throws UploadException the upload exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ApiException the api exception
	 * @throws PeerConnectionNotFoundException the peer connection not found exception
	 */
	// can only be called if the connection is local really.
	private UploadData handlePathUpload(UploadPathParameter uploadParameter)
			throws UploadException, IOException, ApiException, PeerConnectionNotFoundException {

		if (peerConnection instanceof RemotePeerConnection) {
			throw new PeerConnectionNotFoundException("Can't use RemotePeerConnection for Path upload");
		}

		String publishedData = "";
		if (uploadParameter.getMosaics() == null) {
			uploadParameter.setMosaics(new Mosaic[0]);
		}

		UploadData uploadData = new UploadData();
		byte[] encrypted = null;
		BinaryTransactionEncryptedMessage response = null;
		try {
			if (uploadParameter.getMessageType() == MessageTypes.SECURE) {
				encrypted = engine
						.createBlockCipher(
								new KeyPair(PrivateKey.fromHexString(uploadParameter.getSenderPrivateKey()), engine),
								new KeyPair(PublicKey.fromHexString(uploadParameter.getRecipientPublicKey()), engine))
						.encrypt(uploadParameter.getPath().getBytes());

				String encryptedData = HexEncoder.getString(encrypted);
				response = ((LocalDataHashApi) dataHashApi).generateHashAndExposePath(encryptedData,
						uploadParameter.getName(), uploadParameter.getKeywords(), uploadParameter.getMetaData());
			} else { // PLAIN
				response = ((LocalDataHashApi) dataHashApi).generateHashAndExposePath(uploadParameter.getPath(),
						uploadParameter.getName(), uploadParameter.getKeywords(), uploadParameter.getMetaData());
			}

			if (this.isLocalPeerConnection) {
				// Announce The Signature
				NemAnnounceResult announceResult = BinaryTransferTransactionBuilder
						.sender(new Account(
								new KeyPair(PrivateKey.fromHexString(uploadParameter.getSenderPrivateKey()))))
						.recipient(new Account(Address
								.fromPublicKey(PublicKey.fromHexString(uploadParameter.getRecipientPublicKey()))))
						.version(2).amount(Amount.fromNem(1l))
						.message(JsonUtils.toJson(response), uploadParameter.getMessageType())
						.addMosaics(uploadParameter.getMosaics()).buildSignAndSendTransaction();
				publishedData = announceResult.getTransactionHash().toString();

			}

			uploadData.setDataMessage(response);
			uploadData.setNemHash(publishedData);
		} catch (Exception e) {
			e.printStackTrace();
			dataHashApi.cleanupPinnedContentUsingPOST(response.getHash());
			throw new UploadException(e);
		}
		return uploadData;
	}

	/**
	 * Creates the zip.
	 *
	 * @param files the files
	 * @return the byte[]
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private byte[] createZip(Map<String, byte[]> files) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ZipOutputStream zipfile = new ZipOutputStream(bos);
		Iterator<String> i = files.keySet().iterator();
		String fileName = null;
		ZipEntry zipentry = null;
		while (i.hasNext()) {
			fileName = (String) i.next();
			zipentry = new ZipEntry(fileName);
			zipfile.putNextEntry(zipentry);
			zipfile.write((byte[]) files.get(fileName));
		}
		zipfile.close();
		return bos.toByteArray();
	}

}
