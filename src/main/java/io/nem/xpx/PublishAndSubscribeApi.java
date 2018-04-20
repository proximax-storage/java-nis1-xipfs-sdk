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


package io.nem.xpx;

import io.nem.api.ApiCallback;
import io.nem.api.ApiClient;
import io.nem.api.ApiException;
import io.nem.api.ApiResponse;
import io.nem.Configuration;
import io.nem.Pair;
import io.nem.ProgressRequestBody;
import io.nem.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;



import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PublishAndSubscribeApi {
    private ApiClient apiClient;

    public PublishAndSubscribeApi() {
        this(Configuration.getDefaultApiClient());
    }

    public PublishAndSubscribeApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for publishTopicUsingGET
     * @param topic Topic (required)
     * @param message Initial Message (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call publishTopicUsingGETCall(String topic, String message, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/pubsub/init/{topic}"
            .replaceAll("\\{" + "topic" + "\\}", apiClient.escapeString(topic.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (message != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "message", message));

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
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call publishTopicUsingGETValidateBeforeCall(String topic, String message, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'topic' is set
        if (topic == null) {
            throw new ApiException("Missing the required parameter 'topic' when calling publishTopicUsingGET(Async)");
        }
        
        
        com.squareup.okhttp.Call call = publishTopicUsingGETCall(topic, message, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Publish and Subscribe. Make sure that the IPFS daemon has pubsub enabled.
     * Publish and Subscribe. Make sure that the IPFS daemon has pubsub enabled.
     * @param topic Topic (required)
     * @param message Initial Message (optional)
     * @return Object
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Object publishTopicUsingGET(String topic, String message) throws ApiException {
        ApiResponse<Object> resp = publishTopicUsingGETWithHttpInfo(topic, message);
        return resp.getData();
    }

    /**
     * Publish and Subscribe. Make sure that the IPFS daemon has pubsub enabled.
     * Publish and Subscribe. Make sure that the IPFS daemon has pubsub enabled.
     * @param topic Topic (required)
     * @param message Initial Message (optional)
     * @return ApiResponse&lt;Object&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Object> publishTopicUsingGETWithHttpInfo(String topic, String message) throws ApiException {
        com.squareup.okhttp.Call call = publishTopicUsingGETValidateBeforeCall(topic, message, null, null);
        Type localVarReturnType = new TypeToken<Object>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Publish and Subscribe. Make sure that the IPFS daemon has pubsub enabled. (asynchronously)
     * Publish and Subscribe. Make sure that the IPFS daemon has pubsub enabled.
     * @param topic Topic (required)
     * @param message Initial Message (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call publishTopicUsingGETAsync(String topic, String message, final ApiCallback<Object> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = publishTopicUsingGETValidateBeforeCall(topic, message, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Object>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}