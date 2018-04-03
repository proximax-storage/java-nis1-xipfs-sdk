/*
 * Proximax REST API
 * Proximax REST API
 *
 * OpenAPI spec version: v0.0.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.nem.xpx;

import io.nem.ApiException;
import io.nem.xpx.model.BinaryTransactionEncryptedMessage;
import org.junit.Test;
import org.junit.Ignore;
import java.util.List;


/**
 * API tests for SearchApi.
 */
@Ignore
public class SearchApiTest extends AbstractApiTest {

	/** The api. */
	private final SearchApi api = new SearchApi();

	/**
	 * Search through all the owner&#39;s documents to find a content that
	 * matches the text specified.
	 *
	 * This endpoint can only be used to look up publicly available resources
	 * (PLAIN and SECURE Message Types).
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	@Ignore("This test can only be ran if you're running the node locally. e.i: set the api client base url to localhost")
	public void searchContentUsingAllNemHashUsingGETTest() throws ApiException {
		String xPvkey = null;
		String nemHash = null;
		String response = api.searchContentUsingAllNemHashUsingGET(xPvkey, nemHash);

		// TODO: test validations
	}

	/**
	 * Search through all the owner&#39;s documents to find a content that
	 * matches the text specified.
	 *
	 * This endpoint can only be used to look up publicly available resources
	 * (PLAIN Message Types).
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void searchContentUsingPublicNemHashUsingGETTest() throws ApiException {
		String xPubkey = null;
		String nemHash = null;
		String response = api.searchContentUsingPublicNemHashUsingGET(xPubkey, nemHash);

		// TODO: test validations
	}

	/**
	 * Search through all the owner&#39;s documents to find a content that
	 * matches the text specified.
	 *
	 * This endpoint can only be used to look up publicly available resources
	 * (PLAIN Message Types).
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void searchContentUsingTextUsingGETTest() throws ApiException {
		String xPubkey = null;
		String text = null;
		String response = api.searchContentUsingTextUsingGET(xPubkey, text);

		// TODO: test validations
	}

	/**
	 * Search through all the owners documents to find a content that matches
	 * the text specified.
	 *
	 * This endpoint can only be used to look up publicly available resources
	 * (PLAIN and SECURE Message Types).
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	@Ignore("This test can only be ran if you're running the node locally. e.i: set the api client base url to localhost")
	public void searchTransactionPvKeyWithKeywordUsingGETTest() throws ApiException {
		String xPvkey = null;
		String keywords = null;
		List<BinaryTransactionEncryptedMessage> response = api.searchTransactionPvKeyWithKeywordUsingGET(xPvkey,
				keywords);

		// TODO: test validations
	}

	/**
	 * Search through all the owners documents to find a content that matches
	 * the text specified.
	 *
	 * This endpoint can only be used to look up publicly available resources
	 * (PLAIN Message Types).
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void searchTransactionWithKeywordUsingGETTest() throws ApiException {
		String xPubkey = null;
		String keywords = null;
		List<BinaryTransactionEncryptedMessage> response = api.searchTransactionWithKeywordUsingGET(xPubkey, keywords);

		// TODO: test validations
	}

	/**
	 * Search through all the owners documents to find a key that matches the
	 * specified parameter key
	 *
	 * This endpoint can only be used to look up publicly available resources
	 * (PLAIN Message Types).
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void searchTransactionWithMetadataUsingGETTest() throws ApiException {
		String xPubkey = null;
		String text = null;
		List<BinaryTransactionEncryptedMessage> response = api.searchTransactionWithMetadataUsingGET(xPubkey, text);

		// TODO: test validations
	}

}
