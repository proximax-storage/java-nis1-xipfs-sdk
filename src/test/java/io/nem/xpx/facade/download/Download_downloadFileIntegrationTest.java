package io.nem.xpx.facade.download;

import io.nem.xpx.facade.AbstractFacadeIntegrationTest;
import io.nem.xpx.model.NemMessageType;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import static io.nem.xpx.facade.DataTextContentType.APPLICATION_PDF;
import static io.nem.xpx.facade.DataTextContentType.TEXT_PLAIN;
import static io.nem.xpx.testsupport.Constants.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class Download_downloadFileIntegrationTest extends AbstractFacadeIntegrationTest {

	private Download unitUnderTest;

	@Before
	public void setUp() {
		unitUnderTest = new Download(peerConnection);
	}

	@Test
	public void shouldDownloadPlainBinary() throws Exception {

		byte[] expected = FileUtils.readFileToByteArray(PDF_FILE1);

		final DownloadFileResult message = unitUnderTest.downloadFile(DownloadParameter.create()
				.nemHash(FILE_TO_PLAIN_MSG_NEM_HASH_MAP.get(PDF_FILE1)).build());

		assertArrayEquals(expected, message.getData());
		assertEquals(NemMessageType.PLAIN, message.getMessageType());
		assertEquals(PDF_FILE1.getName(), message.getFileName());
		assertEquals(APPLICATION_PDF.toString(), message.getContentType());
	}

	@Test
	public void shouldDownloadPlainLargeBinary() throws Exception {

		byte[] expected = FileUtils.readFileToByteArray(PDF_FILE2);

		final DownloadFileResult message = unitUnderTest.downloadFile(DownloadParameter.create()
				.nemHash(FILE_TO_PLAIN_MSG_NEM_HASH_MAP.get(PDF_FILE2)).build());

		assertArrayEquals(expected, message.getData());
		assertEquals(NemMessageType.PLAIN, message.getMessageType());
		assertEquals(PDF_FILE2.getName(), message.getFileName());
		assertEquals(APPLICATION_PDF.toString(), message.getContentType());
	}

	@Test
	public void shouldDownloadSecureBinary()throws Exception {

		byte[] expected = FileUtils.readFileToByteArray(SMALL_FILE);

		final DownloadFileResult message = unitUnderTest.downloadFile(DownloadParameter.create()
				.nemHash(FILE_TO_SECURE_MSG_NEM_HASH_MAP.get(SMALL_FILE))
				.securedWithNemKeysPrivacyStrategy(TEST_PRIVATE_KEY, TEST_PUBLIC_KEY)
				.build());

		assertArrayEquals(expected, message.getData());
		assertEquals(NemMessageType.SECURE, message.getMessageType());
		assertEquals(SMALL_FILE.getName(), message.getFileName());
		assertEquals(TEXT_PLAIN.toString(), message.getContentType());
	}


	@Test
	public void downloadSecureLargeBinaryTest() throws Exception {

		byte[] expected = FileUtils.readFileToByteArray(PDF_FILE2);

		final DownloadFileResult message = unitUnderTest.downloadFile(DownloadParameter.create()
				.nemHash(FILE_TO_SECURE_MSG_NEM_HASH_MAP.get(PDF_FILE2))
				.securedWithNemKeysPrivacyStrategy(TEST_PRIVATE_KEY, TEST_PUBLIC_KEY)
				.build());

		assertArrayEquals(expected, message.getData());
		assertEquals(NemMessageType.SECURE, message.getMessageType());
		assertEquals(PDF_FILE2.getName(), message.getFileName());
		assertEquals(APPLICATION_PDF.toString(), message.getContentType());
	}
}
