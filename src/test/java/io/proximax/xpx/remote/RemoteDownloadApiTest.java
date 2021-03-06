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

package io.proximax.xpx.remote;
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


import io.proximax.xpx.exceptions.ApiException;
import io.proximax.xpx.service.remote.RemoteDownloadApi;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.UnsupportedEncodingException;




/**
 * API tests for DownloadApi.
 */
@Ignore
public class RemoteDownloadApiTest extends AbstractApiTest {

	/** The api. */
	private final RemoteDownloadApi api = new RemoteDownloadApi(apiClient);

	/**
	 * Download resource/file using NEM Transaction Hash
	 *
	 * This endpoint returns either a byte array format of the actual file OR a
	 * JSON format GenericMessageResponse.
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 */
	@Test
	public void downloadPlainMessageFileUsingNemHashUsingGETTest() throws ApiException {
		String nemhash = this.testnetPlainNemTxnHash;
		byte[] response = api.downloadTextUsingGET(nemhash,"bytes");
		Assert.assertNotNull(response);
	}

	/**
	 * Download plain resource/file using NEM Transaction Hash
	 * 
	 * This endpoint returns a byte array format of the actual file.
	 *
	 * @throws ApiException
	 *             if the Api call fails
	 * @throws UnsupportedEncodingException
	 *             the unsupported encoding exception
	 */
	@Test
	@Ignore("This test can only be ran if you're running the node locally. e.i: set the api client base url to localhost")
	public void downloadRawBytesPlainMessageFileUsingNemHashUsingGETTest()
			throws ApiException, UnsupportedEncodingException {
		String nemhash = this.testnetPlainNemTxnHash;
		byte[] response = api.downloadTextUsingGET(nemhash,"bytes");

		Assert.assertNotNull(new String(response, "UTF-8"));
	}


}
