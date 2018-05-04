/*
 * Proximax P2P Storage REST API
 * Proximax P2P Storage REST API
 *
 * OpenAPI spec version: v0.0.1
 * Contact: proximax.storage@proximax.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.nem.xpx.service.remote;

import io.nem.ApiCallback;
import io.nem.ApiClient;
import io.nem.ApiResponse;
import io.nem.Pair;
import io.nem.ProgressRequestBody;
import io.nem.ProgressResponseBody;
import io.nem.xpx.exceptions.ApiException;
import io.nem.xpx.service.intf.DirectoryLoadApi;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;



import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * The Class RemoteDirectoryLoadApi.
 */
public class RemoteDirectoryLoadApi implements DirectoryLoadApi {
    
    /** The api client. */
    private final ApiClient apiClient;

    /**
     * Instantiates a new remote directory load api.
     *
     * @param apiClient the api client
     */
    public RemoteDirectoryLoadApi(ApiClient apiClient) {
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
     * Build call for loadDirectoryUsingGET.
     *
     * @param nemHash NEM Txn (Public) linked to the directory (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call loadDirectoryUsingGETCall(String nemHash, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/directory/load/{nemHash}/**"
            .replaceAll("\\{" + "nemHash" + "\\}", apiClient.escapeString(nemHash.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "*/*"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    /**
     * Load directory using GET validate before call.
     *
     * @param nemHash the nem hash
     * @param progressListener the progress listener
     * @param progressRequestListener the progress request listener
     * @return the com.squareup.okhttp. call
     * @throws ApiException the api exception
     */
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call loadDirectoryUsingGETValidateBeforeCall(String nemHash, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'nemHash' is set
        if (nemHash == null) {
            throw new ApiException("Missing the required parameter 'nemHash' when calling loadDirectoryUsingGET(Async)");
        }
        
        
        com.squareup.okhttp.Call call = loadDirectoryUsingGETCall(nemHash, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Loads a Static Content.
     * Loads a Static Content.
     * @param nemHash NEM Txn (Public) linked to the directory (required)
     * @return Object
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Object loadDirectoryUsingGET(String nemHash) throws ApiException {
        ApiResponse<Object> resp = loadDirectoryUsingGETWithHttpInfo(nemHash);
        return resp.getData();
    }

    /**
     * Loads a Static Content.
     * Loads a Static Content.
     * @param nemHash NEM Txn (Public) linked to the directory (required)
     * @return ApiResponse&lt;Object&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Object> loadDirectoryUsingGETWithHttpInfo(String nemHash) throws ApiException {
        com.squareup.okhttp.Call call = loadDirectoryUsingGETValidateBeforeCall(nemHash, null, null);
        Type localVarReturnType = new TypeToken<Object>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Loads a Static Content. (asynchronously)
     * Loads a Static Content.
     * @param nemHash NEM Txn (Public) linked to the directory (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call loadDirectoryUsingGETAsync(String nemHash, final ApiCallback<Object> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = loadDirectoryUsingGETValidateBeforeCall(nemHash, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Object>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
