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
import io.nem.xpx.model.GenericResponseMessage;
import io.nem.xpx.model.NodeInfo;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for NodeApi.
 */
public class NodeApiTest extends AbstractApiTest {

    /** The api. */
    private final NodeApi api = new NodeApi();

    
    /**
     * Check if the Storage Node is up and running.
     *
     * This endpoint is used to check if the P2P Storage Node instance is either alive or down.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void checkNodeUsingGETTest() throws ApiException {
    	GenericResponseMessage response = api.checkNodeUsingGET();
    	
    	Assert.assertNotNull(response);
    }
    
    /**
     * Get Storage Node Information
     * 
     * This endpoint returns the information of the P2P Storage Node.
     *
     * @return the node info using GET test
     * @throws ApiException          if the Api call fails
     */
    @Test
    public void getNodeInfoUsingGETTest() throws ApiException {
        NodeInfo response = api.getNodeInfoUsingGET();

        Assert.assertNotNull(response);
    }
    
    /**
     * Get Storage Node Information
     * 
     * This endpoint returns the information of the P2P Storage Node.
     *
     * @throws ApiException          if the Api call fails
     */
    @Test
    @Ignore("This test can only be ran if you're running the node locally. e.i: set the api client base url to localhost")
    public void setBlockchainNodeConnectionUsingPOSTTest() throws ApiException {
        String network = null;
        String domain = null;
        String port = null;
        String response = api.setBlockchainNodeConnectionUsingPOST(network, domain, port);

        Assert.assertNotNull(response);
    }
    
}
