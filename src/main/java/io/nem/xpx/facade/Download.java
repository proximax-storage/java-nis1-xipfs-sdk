/*
 * 
 */
package io.nem.xpx.facade;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.concurrent.ExecutionException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.apache.commons.codec.binary.Base64;
import org.nem.core.crypto.CryptoEngine;
import org.nem.core.crypto.CryptoEngines;
import org.nem.core.crypto.KeyPair;
import org.nem.core.crypto.PrivateKey;
import org.nem.core.crypto.PublicKey;
import org.nem.core.messages.SecureMessage;
import org.nem.core.model.Account;
import org.nem.core.model.Address;
import org.nem.core.model.MessageTypes;
import org.nem.core.model.TransferTransaction;
import org.nem.core.model.ncc.TransactionMetaDataPair;

import io.nem.api.ApiException;
import io.nem.xpx.LocalDownloadApi;
import io.nem.xpx.RemoteDownloadApi;
import io.nem.xpx.TransactionApi;
import io.nem.xpx.facade.connection.PeerConnection;
import io.nem.xpx.facade.connection.RemotePeerConnection;
import io.nem.xpx.facade.model.DownloadData;
import io.nem.xpx.intf.DownloadApi;
import io.nem.xpx.model.PeerConnectionNotFoundException;
import io.nem.xpx.model.buffers.ResourceHashMessage;
import io.nem.xpx.utils.CryptoUtils;


/**
 * The Class Download.
 */
public class Download {

	/** The peer connection. */
	private PeerConnection peerConnection;

	/** The download api. */
	private DownloadApi downloadApi;

	/** The engine. */
	private CryptoEngine engine;

	/**
	 * Instantiates a new download.
	 */
	public Download() {}

	/**
	 * Instantiates a new download.
	 *
	 * @param peerConnection            the peer connection
	 * @throws PeerConnectionNotFoundException the peer connection not found exception
	 */
	public Download(PeerConnection peerConnection) throws PeerConnectionNotFoundException {

		if (peerConnection == null) {
			throw new PeerConnectionNotFoundException("PeerConnection can't be null");
		}

		if (peerConnection instanceof RemotePeerConnection) {
			this.downloadApi = new RemoteDownloadApi();
		} else {
			this.downloadApi = new LocalDownloadApi();
		}

		this.peerConnection = peerConnection;
		this.engine = CryptoEngines.ed25519Engine();

	}

	/**
	 * Download public data.
	 *
	 * @param nemHash            the nem hash
	 * @return the download data
	 * @throws InterruptedException             the interrupted exception
	 * @throws ExecutionException             the execution exception
	 * @throws ApiException             the api exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public DownloadData downloadPlain(String nemHash)
			throws InterruptedException, ExecutionException, ApiException, IOException {

		DownloadData downloadData = new DownloadData();
		byte[] securedResponse = null;
		
		TransactionMetaDataPair transactionMetaDataPair = TransactionApi.getTransaction(nemHash);
		TransferTransaction bTrans = ((TransferTransaction) transactionMetaDataPair.getEntity());
		ResourceHashMessage resourceMessage = ResourceHashMessage.getRootAsResourceHashMessage(ByteBuffer.wrap(Base64.decodeBase64(bTrans.getMessage().getEncodedPayload())));
		
		securedResponse = downloadApi.downloadUsingDataHashUsingGET(resourceMessage.hash());
		downloadData.setData(Base64.decodeBase64(securedResponse));
		downloadData.setDataMessage(resourceMessage);
		downloadData.setMessageType(MessageTypes.PLAIN);
		return downloadData;

	}
	
	
	
	
	public DownloadData downloadFile(String nemHash,String transferType)
			throws InterruptedException, ExecutionException, ApiException, IOException {

		DownloadData downloadData = new DownloadData();
		byte[] securedResponse = null;
		
		TransactionMetaDataPair transactionMetaDataPair = TransactionApi.getTransaction(nemHash);
		TransferTransaction bTrans = ((TransferTransaction) transactionMetaDataPair.getEntity());
		ResourceHashMessage resourceMessage = ResourceHashMessage.getRootAsResourceHashMessage(ByteBuffer.wrap(Base64.decodeBase64(bTrans.getMessage().getEncodedPayload())));

		securedResponse = downloadApi.downloadFileUsingGET(nemHash, transferType);
		downloadData.setData(securedResponse);
		downloadData.setDataMessage(resourceMessage);
		downloadData.setMessageType(MessageTypes.PLAIN);
		return downloadData;
		
	}
	
	public DownloadData downloadBinary(String nemHash,String transferType)
			throws InterruptedException, ExecutionException, ApiException, IOException {

		DownloadData downloadData = new DownloadData();
		byte[] securedResponse = null;
		
		TransactionMetaDataPair transactionMetaDataPair = TransactionApi.getTransaction(nemHash);
		TransferTransaction bTrans = ((TransferTransaction) transactionMetaDataPair.getEntity());
		ResourceHashMessage resourceMessage = ResourceHashMessage.getRootAsResourceHashMessage(ByteBuffer.wrap(Base64.decodeBase64(bTrans.getMessage().getEncodedPayload())));

		securedResponse = downloadApi.downloadBinaryUsingGET(nemHash, transferType);
		downloadData.setData(securedResponse);
		downloadData.setDataMessage(resourceMessage);
		downloadData.setMessageType(MessageTypes.PLAIN);
		return downloadData;

	}
	
	
	public DownloadData downloadSecureBinaryOrFile(String nemHash, String senderOrReceiverPrivateKey,
			String senderOrReceiverPublicKey)
			throws ApiException, InterruptedException, ExecutionException, IOException {
		return downloadSecureBinaryOrFile(nemHash,"bytes",senderOrReceiverPrivateKey,senderOrReceiverPublicKey);
	}
	
	public DownloadData downloadSecureTextData(String nemHash, String senderOrReceiverPrivateKey,
			String senderOrReceiverPublicKey)
			throws ApiException, InterruptedException, ExecutionException, IOException {
		return downloadSecureTextData(nemHash,"bytes",senderOrReceiverPrivateKey,senderOrReceiverPublicKey);
	}
	
	public DownloadData downloadSecureBinaryOrFile(String nemHash, String transferType, String senderOrReceiverPrivateKey,
			String senderOrReceiverPublicKey)
			throws ApiException, InterruptedException, ExecutionException, IOException {
		DownloadData downloadData = new DownloadData();
		byte[] securedResponse = null;
		SecureMessage message;
		//BinaryTransactionEncryptedMessage binaryEncryptedData = new BinaryTransactionEncryptedMessage();

		// get the addresses
		// private key address
		PrivateKey privateKey = PrivateKey.fromHexString(senderOrReceiverPrivateKey);
		KeyPair keyPair = new KeyPair(privateKey);
		String senderOrReceiverPrivateKeyAddress = Address.fromPublicKey(keyPair.getPublicKey()).toString();

		// Evaluate the transaction.
		TransferTransaction transaction = (TransferTransaction) TransactionApi.getTransaction(nemHash).getEntity();

		if (transaction.getMessage().getType() == 2) {
			if (transaction.getSigner().getAddress().getEncoded().equals(senderOrReceiverPrivateKeyAddress)) {

				message = SecureMessage.fromEncodedPayload(
						new Account(new KeyPair(PrivateKey.fromHexString(senderOrReceiverPrivateKey), engine)),
						new Account(new KeyPair(PublicKey.fromHexString(senderOrReceiverPublicKey), engine)),
						transaction.getMessage().getEncodedPayload());
				
				ResourceHashMessage resourceMessage = ResourceHashMessage.getRootAsResourceHashMessage(ByteBuffer.wrap(Base64.decodeBase64(message.getDecodedPayload())));
				securedResponse = downloadApi.downloadUsingDataHashUsingGET(resourceMessage.hash());

				byte[] decrypted = engine
						.createBlockCipher(
								new KeyPair(PublicKey.fromHexString(senderOrReceiverPublicKey), engine),
								new KeyPair(PrivateKey.fromHexString(senderOrReceiverPrivateKey), engine))
						.decrypt(securedResponse);
				
				downloadData.setData(decrypted);
				downloadData.setDataMessage(resourceMessage);
				downloadData.setMessageType(MessageTypes.SECURE);
				return downloadData;
			} else if (transaction.getRecipient().getAddress().getEncoded().equals(senderOrReceiverPrivateKeyAddress)) {

				message = SecureMessage.fromEncodedPayload(
						new Account(new KeyPair(PublicKey.fromHexString(senderOrReceiverPublicKey), engine)),
						new Account(new KeyPair(PrivateKey.fromHexString(senderOrReceiverPrivateKey), engine)),
						transaction.getMessage().getEncodedPayload());

				ResourceHashMessage resourceMessage = ResourceHashMessage.getRootAsResourceHashMessage(ByteBuffer.wrap(Base64.decodeBase64(message.getDecodedPayload())));

				securedResponse = downloadApi.downloadUsingDataHashUsingGET(resourceMessage.hash());

				byte[] decrypted = engine
						.createBlockCipher(new KeyPair(PrivateKey.fromHexString(senderOrReceiverPrivateKey), engine),
								new KeyPair(PublicKey.fromHexString(senderOrReceiverPublicKey), engine))
						.decrypt(securedResponse);
				//byte[] decoded = Base64.decodeBase64(decrypted);
				downloadData.setData(decrypted);
				downloadData.setDataMessage(resourceMessage);
				downloadData.setMessageType(MessageTypes.SECURE);
				return downloadData;

			}

		} else if (transaction.getMessage().getType() == 1) {

			ResourceHashMessage resourceMessage = ResourceHashMessage.getRootAsResourceHashMessage(ByteBuffer.wrap(Base64.decodeBase64(transaction.getMessage().getDecodedPayload())));

			securedResponse = downloadApi.downloadTextUsingGET(nemHash,transferType);

			downloadData.setData(securedResponse);
			downloadData.setDataMessage(resourceMessage);
			downloadData.setMessageType(MessageTypes.PLAIN);
			return downloadData;
		}

		return downloadData;
	}
	
	public DownloadData downloadSecureTextData(String nemHash, String transferType, String senderOrReceiverPrivateKey,
			String senderOrReceiverPublicKey)
			throws ApiException, InterruptedException, ExecutionException, IOException {
		DownloadData downloadData = new DownloadData();
		byte[] securedResponse = null;
		SecureMessage message;
		//BinaryTransactionEncryptedMessage binaryEncryptedData = new BinaryTransactionEncryptedMessage();

		// get the addresses
		// private key address
		PrivateKey privateKey = PrivateKey.fromHexString(senderOrReceiverPrivateKey);
		KeyPair keyPair = new KeyPair(privateKey);
		String senderOrReceiverPrivateKeyAddress = Address.fromPublicKey(keyPair.getPublicKey()).toString();

		// Evaluate the transaction.
		TransferTransaction transaction = (TransferTransaction) TransactionApi.getTransaction(nemHash).getEntity();

		if (transaction.getMessage().getType() == 2) {
			if (transaction.getSigner().getAddress().getEncoded().equals(senderOrReceiverPrivateKeyAddress)) {

				message = SecureMessage.fromEncodedPayload(
						new Account(new KeyPair(PrivateKey.fromHexString(senderOrReceiverPrivateKey), engine)),
						new Account(new KeyPair(PublicKey.fromHexString(senderOrReceiverPublicKey), engine)),
						transaction.getMessage().getEncodedPayload());
				
				ResourceHashMessage resourceMessage = ResourceHashMessage.getRootAsResourceHashMessage(ByteBuffer.wrap(Base64.decodeBase64(message.getDecodedPayload())));
				securedResponse = downloadApi.downloadUsingDataHashUsingGET(resourceMessage.hash());
				
				byte[] decrypted = engine
						.createBlockCipher(
								new KeyPair(PublicKey.fromHexString(senderOrReceiverPublicKey), engine),
								new KeyPair(PrivateKey.fromHexString(senderOrReceiverPrivateKey), engine))
						.decrypt(Base64.decodeBase64(securedResponse));
	
				downloadData.setData(decrypted);
				downloadData.setDataMessage(resourceMessage);
				downloadData.setMessageType(MessageTypes.SECURE);
				return downloadData;
			} else if (transaction.getRecipient().getAddress().getEncoded().equals(senderOrReceiverPrivateKeyAddress)) {

				message = SecureMessage.fromEncodedPayload(
						new Account(new KeyPair(PublicKey.fromHexString(senderOrReceiverPublicKey), engine)),
						new Account(new KeyPair(PrivateKey.fromHexString(senderOrReceiverPrivateKey), engine)),
						transaction.getMessage().getEncodedPayload());

				ResourceHashMessage resourceMessage = ResourceHashMessage.getRootAsResourceHashMessage(ByteBuffer.wrap(Base64.decodeBase64(message.getDecodedPayload())));

				securedResponse = downloadApi.downloadUsingDataHashUsingGET(resourceMessage.hash());

				byte[] decrypted = engine
						.createBlockCipher(new KeyPair(PrivateKey.fromHexString(senderOrReceiverPrivateKey), engine),
								new KeyPair(PublicKey.fromHexString(senderOrReceiverPublicKey), engine))
						.decrypt(Base64.decodeBase64(securedResponse));
				downloadData.setData(decrypted);
				downloadData.setDataMessage(resourceMessage);
				downloadData.setMessageType(MessageTypes.SECURE);
				return downloadData;

			}

		} else if (transaction.getMessage().getType() == 1) {

			ResourceHashMessage resourceMessage = ResourceHashMessage.getRootAsResourceHashMessage(ByteBuffer.wrap(Base64.decodeBase64(transaction.getMessage().getDecodedPayload())));

			securedResponse = downloadApi.downloadTextUsingGET(nemHash,transferType);

			downloadData.setData(securedResponse);
			downloadData.setDataMessage(resourceMessage);
			downloadData.setMessageType(MessageTypes.PLAIN);
			return downloadData;
		}

		return downloadData;
	}



	public DownloadData downloadMultisigFileOrData(int messageType, String nemHash, String keySecret)
			throws ApiException, InterruptedException, ExecutionException, IOException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException {
		DownloadData downloadData = new DownloadData();
		byte[] securedResponse = null;
		// Evauate the transaction.
		TransferTransaction transaction = (TransferTransaction) TransactionApi.getTransaction(nemHash).getEntity();
		
		
		if(transaction.getSignature() != null) {
			if(messageType == MessageTypes.SECURE) {
				byte[] decrypted = null;
				
				ResourceHashMessage resourceMessage = ResourceHashMessage.getRootAsResourceHashMessage(ByteBuffer.wrap(Base64.decodeBase64(transaction.getMessage().getDecodedPayload())));

				securedResponse = downloadApi.downloadBinaryUsingGET(nemHash,"");
				decrypted = CryptoUtils.decrypt(securedResponse, keySecret.toCharArray());
				//String encryptedData = HexEncoder.getString(decrypted);
				downloadData.setData(decrypted);
				downloadData.setDataMessage(resourceMessage);
				downloadData.setMessageType(MessageTypes.SECURE);
				return downloadData;
			} else {
				byte[] decrypted = null;
				ResourceHashMessage resourceMessage = ResourceHashMessage.getRootAsResourceHashMessage(ByteBuffer.wrap(Base64.decodeBase64(transaction.getMessage().getDecodedPayload())));
				//String encryptedData = HexEncoder.getString(decrypted);
				downloadData.setData(decrypted);
				downloadData.setDataMessage(resourceMessage);
				downloadData.setMessageType(MessageTypes.PLAIN);
				return downloadData;
			}
		}
		return downloadData;
	}
}
