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

import io.nem.api.ApiException;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DirectoryLoadApi
 */
@Ignore
public class DirectoryLoadApiTest {

    private final DirectoryLoadApi api = new DirectoryLoadApi();

    
    /**
     * Loads a Static Content.
     *
     * Loads a Static Content.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void loadDirectoryUsingGETTest() throws io.nem.api.ApiException {
        String nemHash = null;
        Object response = api.loadDirectoryUsingGET(nemHash);

        // TODO: test validations
    }
    
}
