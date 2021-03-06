/*
 * Copyright 2018 ProximaX Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.proximax.xpx.performance.tests;

import io.proximax.xpx.facade.connection.RemotePeerConnection;
import io.proximax.xpx.facade.upload.UploadAsync;
import io.proximax.xpx.facade.upload.UploadBinaryParameter;
import io.proximax.xpx.facade.upload.UploadResult;
import io.proximax.xpx.remote.AbstractApiTest;
import org.apache.commons.io.FileUtils;
import org.pmw.tinylog.Logger;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static io.proximax.xpx.testsupport.Constants.METADATA_AS_MAP;
import static io.proximax.xpx.testsupport.Constants.TEST_PUBLIC_KEY;
import static io.proximax.xpx.testsupport.Constants.TEST_PRIVATE_KEY;
import static org.junit.Assert.assertNotNull;



/**
 * The Class UploadTest.
 */

public class MultiThreadUploadRemoteBinaryTest extends AbstractApiTest {

	/**
	 * Instantiates a new multi thread upload remote binary test.
	 */
	public MultiThreadUploadRemoteBinaryTest() {

		for (int i = 0; i < 100; i++) {
			Runnable task = () -> {

				RemotePeerConnection remotePeerConnection = new RemotePeerConnection(localNodeBasePath);

				try {
					UploadAsync upload = new UploadAsync(remotePeerConnection);

					UploadBinaryParameter parameter1 = UploadBinaryParameter.create()
							.senderPrivateKey(TEST_PRIVATE_KEY)
							.receiverPublicKey(TEST_PUBLIC_KEY)
							.data(FileUtils.readFileToByteArray(new File("src//test//resources//test_pdf_file_v1.pdf")))
							.name("test_pdf_file_v1")
							.contentType("application/pdf")
							.keywords("pdf_file_version_file1")
							.metadata(METADATA_AS_MAP)
							.build();
					
					UploadBinaryParameter parameter2 = UploadBinaryParameter.create()
							.senderPrivateKey(TEST_PRIVATE_KEY)
							.receiverPublicKey(TEST_PUBLIC_KEY)
							.data(FileUtils.readFileToByteArray(new File("src//test//resources//test_pdf_file_v2.pdf")))
							.name("test_pdf_file_v2")
							.contentType("application/pdf")
							.keywords("pdf_file_version_file2")
							.metadata(METADATA_AS_MAP)
							.build();
					
					UploadBinaryParameter parameter3 = UploadBinaryParameter.create()
							.senderPrivateKey(TEST_PRIVATE_KEY)
							.receiverPublicKey(TEST_PUBLIC_KEY)
							.data(FileUtils.readFileToByteArray(new File("src//test//resources//test_pdf_file_v2.pdf")))
							.name("test_pdf_file_v2")
							.contentType("application/pdf")
							.keywords("pdf_file_version_file3")
							.metadata(METADATA_AS_MAP)
							.build();

					// 	Run the computation on another thread and wait for it to finish.
					//	Callbacks are then handled.
					CompletableFuture<UploadResult> future1 = upload.uploadBinary(parameter1, (n) -> {
						Logger.info(n.getNemHash());
						Logger.info(n.getDataMessage().hash());
						assertNotNull(n.getNemHash());
						
					}).exceptionally(e -> {
						e.printStackTrace();
						return null;
						
					});
					
					CompletableFuture<UploadResult> future2 = upload.uploadBinary(parameter2, (n) -> {
						Logger.info(n.getNemHash());
						Logger.info(n.getDataMessage().hash());
						assertNotNull(n.getNemHash());
					}).exceptionally(e -> {
						e.printStackTrace();
						return null;
						
					});
					
					CompletableFuture<UploadResult> future3 = upload.uploadBinary(parameter3, (n) -> {
						Logger.info(n.getNemHash());
						Logger.info(n.getDataMessage().hash());
						assertNotNull(n.getNemHash());
					}).exceptionally(e -> {
						e.printStackTrace();
						return null;
						
					});

					CompletableFuture<Void> combinedFuture 
					  = CompletableFuture.allOf(future1, future2, future3);
					
					combinedFuture.get();
					
				} catch (IOException | InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			};
			Thread thread = new Thread(task);
			thread.start();
		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		new MultiThreadUploadRemoteBinaryTest();
	}

}
