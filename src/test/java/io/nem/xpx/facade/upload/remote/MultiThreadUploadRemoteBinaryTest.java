package io.nem.xpx.facade.upload.remote;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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

import io.nem.ApiException;
import io.nem.xpx.builder.UploadBinaryParameterBuilder;
import io.nem.xpx.facade.Upload;
import io.nem.xpx.facade.UploadAsync;
import io.nem.xpx.facade.connection.LocalHttpPeerConnection;
import io.nem.xpx.facade.connection.RemotePeerConnection;
import io.nem.xpx.facade.model.UploadData;
import io.nem.xpx.model.PeerConnectionNotFoundException;
import io.nem.xpx.model.UploadBinaryParameter;
import io.nem.xpx.model.UploadException;
import io.nem.xpx.model.XpxSdkGlobalConstants;
import io.nem.xpx.remote.AbstractApiTest;
import io.nem.xpx.utils.JsonUtils;

/**
 * The Class UploadTest.
 */
public class MultiThreadUploadRemoteBinaryTest extends AbstractApiTest {

	public MultiThreadUploadRemoteBinaryTest() {

		for (int i = 0; i < 100; i++) {
			Runnable task = () -> {

				RemotePeerConnection remotePeerConnection = new RemotePeerConnection(uploadNodeBasePath);

				try {
					UploadAsync upload = new UploadAsync(remotePeerConnection);
					Map<String, String> metaData = new HashMap<String, String>();
					metaData.put("key1", "value1");

					UploadBinaryParameter parameter1 = UploadBinaryParameterBuilder.senderOrReceiverPrivateKey(this.xPvkey)
							.receiverOrSenderPublicKey(this.xPubkey).messageType(MessageTypes.PLAIN)
							.data(FileUtils.readFileToByteArray(new File("src//test//resources//pdf_file.pdf")))
							.name("pdf_file2.pdf").keywords("pdf_file2").metaData(JsonUtils.toJson(metaData))
							.contentType("application/pdf") // make sure to put this in for files.
							.build();
					
					UploadBinaryParameter parameter2 = UploadBinaryParameterBuilder.senderOrReceiverPrivateKey(this.xPvkey)
							.receiverOrSenderPublicKey(this.xPubkey).messageType(MessageTypes.PLAIN)
							.data(FileUtils.readFileToByteArray(new File("src//test//resources//pdf_file.pdf")))
							.name("pdf_file2.pdf").keywords("pdf_file2").metaData(JsonUtils.toJson(metaData))
							.contentType("application/pdf") // make sure to put this in for files.
							.build();
					
					UploadBinaryParameter parameter3 = UploadBinaryParameterBuilder.senderOrReceiverPrivateKey(this.xPvkey)
							.receiverOrSenderPublicKey(this.xPubkey).messageType(MessageTypes.PLAIN)
							.data(FileUtils.readFileToByteArray(new File("src//test//resources//pdf_file.pdf")))
							.name("pdf_file2.pdf").keywords("pdf_file2").metaData(JsonUtils.toJson(metaData))
							.contentType("application/pdf") // make sure to put this in for files.
							.build();

					// 	Run the computation on another thread and wait for it to finish.
					//	Callbacks are then handled.
					CompletableFuture<UploadData> future1 = upload.uploadBinary(parameter1, (n) -> {
						System.out.println(n.getNemHash());
					});
					
					CompletableFuture<UploadData> future2 = upload.uploadBinary(parameter2, (n) -> {
						System.out.println(n.getNemHash());
					});
					
					CompletableFuture<UploadData> future3 = upload.uploadBinary(parameter3, (n) -> {
						System.out.println(n.getNemHash());
					});

					CompletableFuture<Void> combinedFuture 
					  = CompletableFuture.allOf(future1, future2, future3);
					
					combinedFuture.get();
					
				} catch (ApiException | IOException | PeerConnectionNotFoundException | InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			};
			Thread thread = new Thread(task);
			thread.start();
		}
	}

	public static void main(String[] args) {
		new MultiThreadUploadRemoteBinaryTest();
	}

}
