package io.nem.xpx.facade.upload.remote;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.nem.core.model.FeeUnitAwareTransactionFeeCalculator;
import org.nem.core.model.MessageTypes;
import org.nem.core.model.mosaic.Mosaic;
import org.nem.core.model.mosaic.MosaicFeeInformationLookup;
import org.nem.core.model.mosaic.MosaicId;
import org.nem.core.model.mosaic.MosaicFeeInformation;
import org.nem.core.model.namespace.NamespaceId;
import org.nem.core.model.primitive.Amount;
import org.nem.core.model.primitive.Quantity;
import org.nem.core.model.primitive.Supply;
import org.nem.core.node.NodeEndpoint;

import io.nem.api.ApiException;
import io.nem.xpx.AbstractApiTest;
import io.nem.xpx.builder.UploadBinaryParameterBuilder;
import io.nem.xpx.facade.Upload;
import io.nem.xpx.facade.connection.LocalHttpPeerConnection;
import io.nem.xpx.facade.connection.RemotePeerConnection;
import io.nem.xpx.model.PeerConnectionNotFoundException;
import io.nem.xpx.model.UploadBinaryParameter;
import io.nem.xpx.model.UploadException;
import io.nem.xpx.model.XpxSdkGlobalConstants;
import io.nem.xpx.utils.JsonUtils;


/**
 * The Class UploadTest.
 */
public class UploadRemoteBinaryTest extends AbstractApiTest {


	/**
	 * Upload plain file test.
	 */
	@Test
	public void uploadPlainBinaryTest() {
		RemotePeerConnection remotePeerConnection = new RemotePeerConnection(localRemote);
		
		try {
			Map<String,String> metaData = new HashMap<String,String>();
			metaData.put("key1", "value1");
			
			Upload upload = new Upload(remotePeerConnection);
			UploadBinaryParameter parameter = UploadBinaryParameterBuilder.senderPrivateKey(this.xPvkey)
					.recipientPublicKey(this.xPubkey).messageType(MessageTypes.PLAIN)
					.data(FileUtils.readFileToByteArray(new File("src//test//resources//ProximaX-Whitepaper-v1.4.pdf")))
					.metaData(JsonUtils.toJson(metaData))
					.keywords("proximax-pdf")
					.contentType("application/pdf") // make sure to put this in for files.
					.build();
			
			String nemhash = upload.uploadBinary(parameter).getNemHash();
			LOGGER.info(nemhash);
			Assert.assertNotNull(nemhash);
		} catch (ApiException | IOException | PeerConnectionNotFoundException | UploadException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	/**
	 * Upload plain large file test.
	 */
	@Test
	public void uploadPlainLargeBinaryTest() {
		RemotePeerConnection remotePeerConnection = new RemotePeerConnection(localRemote);
		
		try {
			Map<String,String> metaData = new HashMap<String,String>();
			metaData.put("key1", "value1");
			Upload upload = new Upload(remotePeerConnection);
			UploadBinaryParameter parameter = UploadBinaryParameterBuilder.senderPrivateKey(this.xPvkey)
					.recipientPublicKey(this.xPubkey).messageType(MessageTypes.PLAIN)
					.data(FileUtils.readFileToByteArray(new File("src//test//resources//ProximaX-Whitepaper-v1.4.pdf")))
					.metaData(JsonUtils.toJson(metaData))
					.keywords("plain,remote,binary,test").build();
			
			String nemhash = upload.uploadBinary(parameter).getNemHash();
			LOGGER.info(nemhash);
			System.out.print(nemhash);
		} catch (ApiException | IOException | PeerConnectionNotFoundException | UploadException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}


	/**
	 * Upload secure file test.
	 */
	@Test
	public void uploadSecureBinaryTest() {
		RemotePeerConnection remotePeerConnection = new RemotePeerConnection(localRemote);
		
		try {
			Map<String,String> metaData = new HashMap<String,String>();
			metaData.put("key1", "value1");
			Upload upload = new Upload(remotePeerConnection);
			UploadBinaryParameter parameter = UploadBinaryParameterBuilder.senderPrivateKey(this.xPvkey)
					.recipientPublicKey(this.xPubkey).messageType(MessageTypes.PLAIN)
					.data(FileUtils.readFileToByteArray(new File("src//test//resources//ProximaX-Whitepaper-v1.4.pdf")))
					.metaData(JsonUtils.toJson(metaData))
					.keywords("secure,binary,test,remote")
					.build();
			
			String nemhash = upload.uploadBinary(parameter).getNemHash();
			LOGGER.info(nemhash);
			System.out.print(nemhash);
		} catch (ApiException | IOException | PeerConnectionNotFoundException | UploadException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	/**
	 * Upload secure large file test.
	 */
	@Test
	public void uploadSecureLargeBinaryTest() {
		RemotePeerConnection remotePeerConnection = new RemotePeerConnection(localRemote);
		
		try {
			Map<String,String> metaData = new HashMap<String,String>();
			metaData.put("key1", "value1");
			Upload upload = new Upload(remotePeerConnection);
			UploadBinaryParameter parameter = UploadBinaryParameterBuilder.senderPrivateKey(this.xPvkey)
					.recipientPublicKey(this.xPubkey).messageType(MessageTypes.PLAIN)
					.data(FileUtils.readFileToByteArray(new File("src//test//resources//ProximaX-Whitepaper-v1.4.pdf")))
					.metaData(JsonUtils.toJson(metaData))
					.keywords("secure,binary,test,remote")
					.build();
			String nemhash = upload.uploadBinary(parameter).getNemHash();
			LOGGER.info(nemhash);
			System.out.print(nemhash);
		} catch (ApiException | IOException | PeerConnectionNotFoundException | UploadException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	@Test
	public void uploadPlainBinaryWithMosaicTest() {
		RemotePeerConnection remotePeerConnection = new RemotePeerConnection(localRemote);
		
		try {
			Map<String,String> metaData = new HashMap<String,String>();
			metaData.put("key1", "value1");
			XpxSdkGlobalConstants.setGlobalTransactionFee(
					new FeeUnitAwareTransactionFeeCalculator(Amount.fromMicroNem(50_000L), mosaicInfoLookup()));
			Upload upload = new Upload(remotePeerConnection);
			metaData.put("key1", "value1");
			
			UploadBinaryParameter parameter = UploadBinaryParameterBuilder.senderPrivateKey(this.xPvkey)
					.recipientPublicKey(this.xPubkey).messageType(MessageTypes.PLAIN)
					.data(FileUtils.readFileToByteArray(new File("src//test//resources//ProximaX-Whitepaper-v1.4.pdf")))
					.metaData(JsonUtils.toJson(metaData))
					.keywords("plain,data,wmosaics")
					.mosaics(new Mosaic(new MosaicId(new NamespaceId("landregistry1"), "registry"),
							Quantity.fromValue(0)))
					.build();

			String nemhash = upload.uploadBinary(parameter).getNemHash();
			LOGGER.info(nemhash);
			Assert.assertNotNull(nemhash);
		} catch (ApiException | PeerConnectionNotFoundException | IOException | UploadException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	/**
	 * Mosaic info lookup.
	 *
	 * @return the mosaic fee information lookup
	 */
	private MosaicFeeInformationLookup mosaicInfoLookup() {
		return id -> {
			if (id.getName().equals("registry")) {
				return new MosaicFeeInformation(Supply.fromValue(8_999_999_999L), 6);
			}
			final int multiplier = Integer.parseInt(id.getName().substring(4));
			final int divisibilityChange = multiplier - 1;
			return new MosaicFeeInformation(Supply.fromValue(100_000_000 * multiplier), 3 + divisibilityChange);
		};
	}


}
