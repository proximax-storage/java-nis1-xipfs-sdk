/*
 * Proximax P2P Storage REST API
 * Proximax P2P Storage REST API
 *
 * OpenAPI spec version: v0.0.1
 * Contact: alvin.reyes@botmill.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.nem.xpx.service.remote;

import io.nem.Pair;
import io.nem.ProgressRequestBody;
import io.nem.ProgressResponseBody;
import io.nem.ApiCallback;
import io.nem.ApiClient;
import io.nem.ApiResponse;
import io.nem.xpx.exceptions.ApiException;
import io.nem.xpx.service.intf.DataHashApi;

import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * The Class RemoteDataHashApi.
 */
public class RemoteDataHashApi implements DataHashApi {
	
	/** The api client. */
	private final ApiClient apiClient;

	/**
	 * Instantiates a new remote data hash api.
	 *
	 * @param apiClient the api client
	 */
	public RemoteDataHashApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/**
	 * Gets the api client.
	 *
	 * @return the api client
	 */
	public ApiClient getApiClient() {
        return apiClient;
    }

    /**
     * Build call for generateHashForDataOnlyUsingPOST.
     *
     * @param data Free form string data that will be stored on the P2P Network (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call generateHashForDataOnlyUsingPOSTCall(byte[] data, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = data;
        
        // create path and map variables
        String localVarPath = "/datahash/hash-only";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "multipart/form-data"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    /**
     * Generate hash for data only using POST validate before call.
     *
     * @param data the data
     * @param progressListener the progress listener
     * @param progressRequestListener the progress request listener
     * @return the com.squareup.okhttp. call
     * @throws ApiException the api exception
     */
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call generateHashForDataOnlyUsingPOSTValidateBeforeCall(byte[] data, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'data' is set
        if (data == null) {
            throw new ApiException("Missing the required parameter 'data' when calling generateHashForDataOnlyUsingPOST(Async)");
        }
        
        
        com.squareup.okhttp.Call call = generateHashForDataOnlyUsingPOSTCall(data, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Generates the datahash but doesn&#39;t upload the file on the network
     * This endpoint can be used to generates the datahash and uploads the file in the process.
     * @param data Free form string data that will be stored on the P2P Network (required)
     * @return String
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public String generateHashForDataOnlyUsingPOST(byte[] data) throws ApiException {
        ApiResponse<String> resp = generateHashForDataOnlyUsingPOSTWithHttpInfo(data);
        return resp.getData();
    }

    /**
     * Generates the datahash but doesn&#39;t upload the file on the network
     * This endpoint can be used to generates the datahash and uploads the file in the process.
     * @param data Free form string data that will be stored on the P2P Network (required)
     * @return ApiResponse&lt;String&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<String> generateHashForDataOnlyUsingPOSTWithHttpInfo(byte[] data) throws ApiException {
        com.squareup.okhttp.Call call = generateHashForDataOnlyUsingPOSTValidateBeforeCall(data, null, null);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Generates the datahash but doesn&#39;t upload the file on the network (asynchronously)
     * This endpoint can be used to generates the datahash and uploads the file in the process.
     * @param data Free form string data that will be stored on the P2P Network (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call generateHashForDataOnlyUsingPOSTAsync(byte[] data, final ApiCallback<String> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = generateHashForDataOnlyUsingPOSTValidateBeforeCall(data, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<String>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
