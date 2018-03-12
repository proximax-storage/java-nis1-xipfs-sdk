package io.nem.xpx.wrap;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutionException;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.nem.core.utils.HexEncoder;

import io.nem.ApiException;
import io.nem.xpx.AbstractApiTest;
import io.nem.xpx.model.PeerConnectionNotFoundException;

/**
 * The Class DownloadTest.
 */
public class DownloadRemoteTest extends AbstractApiTest {

	/**
	 * Download plain data test.
	 */
	@Test
	public void downloadPlainDataTest() {
		RemotePeerConnection remotePeerConnection = new RemotePeerConnection(downloadNodeBasePath);

		try {
			Download download = new Download(remotePeerConnection);
			DownloadData message = download.downloadData(
					"7c7b7f868f166e95b150654a306478bcfc139387fce3cfb7195a9499668bdf64", this.xPvkey, this.xPubkey);

			// validate the name.
			Assert.assertEquals("Assertion failed: Decryted data is not equal to expected", "1520718531585",
					message.getDataMessage().getName());
			LOGGER.info(message.getDataMessage().getName());
			// validate the content.
			Assert.assertEquals("Assertion failed: Decryted data is not equal to expected", "This is a test data",
					new String(message.getData(), "UTF-8"));

		} catch (ApiException | InterruptedException | ExecutionException | PeerConnectionNotFoundException
				| IOException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	/**
	 * Download plain file test.
	 */
	@Test
	public void downloadPlainFileTest() {
		RemotePeerConnection remotePeerConnection = new RemotePeerConnection(downloadNodeBasePath);

		try {
			Download download = new Download(remotePeerConnection);
			String timeStamp = System.currentTimeMillis() + "";

			DownloadData message = download.downloadData(
					"5d7cc02e8643d5fc08995730014052ef3d32561efbcc93778caccbee0c21a2e9", this.xPvkey, this.xPubkey);

			FileUtils.writeByteArrayToFile(new File("src//test//resources//downloadPlainFileTest_"
					+ message.getDataMessage().getName() + timeStamp + ".txt"),
					HexEncoder.getBytes(new String(message.getData())));

			String fileContentExpected = this.extractExpectedSmallTxtFileContent();
			String fileActual = FileUtils.readFileToString(new File("src//test//resources//downloadPlainFileTest_"
					+ message.getDataMessage().getName() + timeStamp + ".txt"));

			Assert.assertEquals(fileContentExpected, fileActual);

			// Remove file after.
			FileUtils.forceDelete(new File("src//test//resources//downloadPlainFileTest_"
					+ message.getDataMessage().getName() + timeStamp + ".txt"));
		} catch (ApiException | InterruptedException | ExecutionException | IOException | PeerConnectionNotFoundException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	/**
	 * Download plain large file test.
	 */
	@Test
	public void downloadPlainLargeFileTest() {
		RemotePeerConnection remotePeerConnection = new RemotePeerConnection(downloadNodeBasePath);
		

		try {
			Download download = new Download(remotePeerConnection);
			String timeStamp = System.currentTimeMillis() + "";
			long expectedFileSize = this.extractLargeFileSize();
			DownloadData message = download.downloadData(
					"fbfd6ba3202acbe5cc8a58fc7a4fc14b70eab0ca7a9922026f280593c4c5fa24", this.xPvkey, this.xPubkey);

			FileUtils
					.writeByteArrayToFile(
							new File("src//test//resources//downloadPlainLargeFileTest_"
									+ message.getDataMessage().getName() + timeStamp + ".zip"),
							HexEncoder.getBytes(new String(message.getData())));

			long actualFileSize = FileUtils.sizeOf(new File("src//test//resources//downloadPlainLargeFileTest_"
					+ message.getDataMessage().getName() + timeStamp + ".zip"));

			Assert.assertEquals(expectedFileSize, actualFileSize);

			// Remove file after.
			FileUtils.forceDelete(new File("src//test//resources//downloadPlainLargeFileTest_"
					+ message.getDataMessage().getName() + timeStamp + ".zip"));
		} catch (IOException | ApiException | InterruptedException | ExecutionException | PeerConnectionNotFoundException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	/**
	 * Download public data test.
	 */
	@Test
	public void downloadPublicDataTest() {
		RemotePeerConnection remotePeerConnection = new RemotePeerConnection(downloadNodeBasePath);
		

		try {
			Download download = new Download(remotePeerConnection);
			DownloadData message = download
					.downloadPublicData("091c687e59e2c4f83f0b176b86bf178778f0022f47d98cb5e8c6066da4bb56fd");

			// validate the name.
			Assert.assertEquals("Assertion failed: Decryted data is not equal to expected", "1519880173787",
					message.getDataMessage().getName());
			LOGGER.info(message.getDataMessage().getName());
			// validate the content.
			Assert.assertEquals("Assertion failed: Decryted data is not equal to expected", "This is a test data",
					new String(message.getData(), "UTF-8"));
			LOGGER.info(new String(message.getData(), "UTF-8"));
		} catch (ApiException | InterruptedException | ExecutionException | PeerConnectionNotFoundException | IOException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	/**
	 * Download plain public file test.
	 */
	@Test
	public void downloadPlainPublicFileTest() {
		RemotePeerConnection remotePeerConnection = new RemotePeerConnection(downloadNodeBasePath);
		
		try {
			Download download = new Download(remotePeerConnection);
			String timeStamp = System.currentTimeMillis() + "";

			DownloadData message = download
					.downloadPublicData("5d7cc02e8643d5fc08995730014052ef3d32561efbcc93778caccbee0c21a2e9");
			new String(message.getData());

			FileUtils
					.writeByteArrayToFile(
							new File("src//test//resources//downloadPlainPublicFileTest_"
									+ message.getDataMessage().getName() + timeStamp + ".txt"),
							HexEncoder.getBytes(new String(message.getData())));

			String fileContentExpected = this.extractExpectedSmallTxtFileContent();
			String fileActual = FileUtils.readFileToString(new File("src//test//resources//downloadPlainPublicFileTest_"
					+ message.getDataMessage().getName() + timeStamp + ".txt"));

			Assert.assertEquals(fileContentExpected, fileActual);

			// Remove file after.
			FileUtils.forceDelete(new File("src//test//resources//downloadPlainPublicFileTest_"
					+ message.getDataMessage().getName() + timeStamp + ".txt"));

		} catch (ApiException | InterruptedException | ExecutionException | IOException | PeerConnectionNotFoundException e) {
			e.printStackTrace();
			assertTrue(false);
		}

	}

	/**
	 * Download plain public large file test.
	 */
	@Test
	public void downloadPlainPublicLargeFileTest() {
		RemotePeerConnection remotePeerConnection = new RemotePeerConnection(downloadNodeBasePath);
		

		try {
			Download download = new Download(remotePeerConnection);
			String timeStamp = System.currentTimeMillis() + "";
			long expectedFileSize = this.extractLargeFileSize();
			DownloadData message = download
					.downloadPublicData("fbfd6ba3202acbe5cc8a58fc7a4fc14b70eab0ca7a9922026f280593c4c5fa24");

			FileUtils.writeByteArrayToFile(
					new File("src//test//resources//downloadPlainPublicLargeFileTest_"
							+ message.getDataMessage().getName() + timeStamp + ".zip"),
					HexEncoder.getBytes(new String(message.getData())));

			long actualFileSize = FileUtils.sizeOf(new File("src//test//resources//downloadPlainPublicLargeFileTest_"
					+ message.getDataMessage().getName() + timeStamp + ".zip"));

			Assert.assertEquals(expectedFileSize, actualFileSize);
			// Remove file after.
			FileUtils.forceDelete(new File("src//test//resources//downloadPlainPublicLargeFileTest_"
					+ message.getDataMessage().getName() + timeStamp + ".zip"));
		} catch (IOException | ApiException | InterruptedException | ExecutionException | PeerConnectionNotFoundException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	/**
	 * Download secure data test.
	 */
	@Test
	public void downloadSecureDataTest() {
		RemotePeerConnection remotePeerConnection = new RemotePeerConnection(downloadNodeBasePath);
		

		try {
			Download download = new Download(remotePeerConnection);
			DownloadData message = download.downloadData(
					"f2df2e0def5bf86b2e5220c01ebafe30b84b4e78fc1476865e6b8f36851e097a", this.xPvkey, this.xPubkey);

			LOGGER.info(new String(message.getData(), "UTF-8"));
			Assert.assertTrue(true);
		} catch (ApiException | InterruptedException | ExecutionException | PeerConnectionNotFoundException | IOException e) {

			e.printStackTrace();
			assertTrue(false);
		}
	}

	/**
	 * Download secure file test.
	 */
	@Test
	public void downloadSecureFileTest() {
		RemotePeerConnection remotePeerConnection = new RemotePeerConnection(downloadNodeBasePath);
		

		try {
			Download download = new Download(remotePeerConnection);
			String timeStamp = System.currentTimeMillis() + "";
			long expectedFileSize = this.extractSmallFileSize();
			DownloadData message = download.downloadData(
					"dcb0c308fb3bae3678317e4a3999139a233fb6851a6771e5d9484eefb3f0013c", this.xPvkey, this.xPubkey);

			FileUtils.writeByteArrayToFile(new File("src//test//resources//downloadSecureFileTest_"
					+ message.getDataMessage().getName() + timeStamp + ".txt"), message.getData());

			long actualFileSize = FileUtils.sizeOf(new File("src//test//resources//downloadSecureFileTest_"
					+ message.getDataMessage().getName() + timeStamp + ".txt"));

			Assert.assertEquals(expectedFileSize, actualFileSize);
			FileUtils.forceDelete(new File("src//test//resources//downloadSecureFileTest_"
					+ message.getDataMessage().getName() + timeStamp + ".txt"));

		} catch (IOException | ApiException | InterruptedException | ExecutionException | PeerConnectionNotFoundException e) {

			e.printStackTrace();
			assertTrue(false);
		}

	}

	/**
	 * Download secure large file test.
	 */
	@Test
	public void downloadSecureLargeFileTest() {
		RemotePeerConnection remotePeerConnection = new RemotePeerConnection(downloadNodeBasePath);
		

		try {
			Download download = new Download(remotePeerConnection);
			String timeStamp = System.currentTimeMillis() + "";
			long expectedFileSize = this.extractLargeFileSize();
			DownloadData message = download.downloadData(
					"b8d7dd089eceffb9710e56d643e9de91e6469e71d8c8e1979ad48e0371746fee", this.xPvkey, this.xPubkey);

			FileUtils.writeByteArrayToFile(new File("src//test//resources//downloadSecureLargeFileTest_"
					+ message.getDataMessage().getName() + timeStamp + ".zip"), message.getData());

			long actualFileSize = FileUtils.sizeOf(new File("src//test//resources//downloadSecureLargeFileTest_"
					+ message.getDataMessage().getName() + timeStamp + ".zip"));

			Assert.assertEquals(expectedFileSize, actualFileSize);
			FileUtils.forceDelete(new File("src//test//resources//downloadSecureLargeFileTest_"
					+ message.getDataMessage().getName() + timeStamp + ".zip"));
		} catch (IOException | ApiException | InterruptedException | ExecutionException | PeerConnectionNotFoundException e) {

			e.printStackTrace();
			assertTrue(false);
		}
	}

}