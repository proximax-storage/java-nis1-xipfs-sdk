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


package io.proximax.xpx.exceptions;

import java.util.Map;
import java.util.List;




/**
 * The Class ApiException.
 */
@SuppressWarnings("serial")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-25T23:45:59.064-04:00")
public class ApiException extends Exception {
    
    /** The code. */
    private int code = 0;
    
    /** The response headers. */
    private Map<String, List<String>> responseHeaders = null;
    
    /** The response body. */
    private String responseBody = null;

    /**
     * Instantiates a new api exception.
     */
    public ApiException() {}

    /**
     * Instantiates a new api exception.
     *
     * @param throwable the throwable
     */
    public ApiException(Throwable throwable) {
        super(throwable);
    }

    /**
     * Instantiates a new api exception.
     *
     * @param message the message
     */
    public ApiException(String message) {
        super(message);
    }

    /**
     * Instantiates a new api exception.
     *
     * @param message the message
     * @param throwable the throwable
     * @param code the code
     * @param responseHeaders the response headers
     * @param responseBody the response body
     */
    public ApiException(String message, Throwable throwable, int code, Map<String, List<String>> responseHeaders, String responseBody) {
        super(message, throwable);
        this.code = code;
        this.responseHeaders = responseHeaders;
        this.responseBody = responseBody;
    }

    /**
     * Instantiates a new api exception.
     *
     * @param message the message
     * @param code the code
     * @param responseHeaders the response headers
     * @param responseBody the response body
     */
    public ApiException(String message, int code, Map<String, List<String>> responseHeaders, String responseBody) {
        this(message, (Throwable) null, code, responseHeaders, responseBody);
    }

    /**
     * Instantiates a new api exception.
     *
     * @param message the message
     * @param throwable the throwable
     * @param code the code
     * @param responseHeaders the response headers
     */
    public ApiException(String message, Throwable throwable, int code, Map<String, List<String>> responseHeaders) {
        this(message, throwable, code, responseHeaders, null);
    }

    /**
     * Instantiates a new api exception.
     *
     * @param code the code
     * @param responseHeaders the response headers
     * @param responseBody the response body
     */
    public ApiException(int code, Map<String, List<String>> responseHeaders, String responseBody) {
        this((String) null, (Throwable) null, code, responseHeaders, responseBody);
    }

    /**
     * Instantiates a new api exception.
     *
     * @param code the code
     * @param message the message
     */
    public ApiException(int code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * Instantiates a new api exception.
     *
     * @param code the code
     * @param message the message
     * @param responseHeaders the response headers
     * @param responseBody the response body
     */
    public ApiException(int code, String message, Map<String, List<String>> responseHeaders, String responseBody) {
        this(code, message);
        this.responseHeaders = responseHeaders;
        this.responseBody = responseBody;
    }

    /**
     * Get the HTTP status code.
     *
     * @return HTTP status code
     */
    public int getCode() {
        return code;
    }

    /**
     * Get the HTTP response headers.
     *
     * @return A map of list of string
     */
    public Map<String, List<String>> getResponseHeaders() {
        return responseHeaders;
    }

    /**
     * Get the HTTP response body.
     *
     * @return Response body in the form of string
     */
    public String getResponseBody() {
        return responseBody;
    }
}
