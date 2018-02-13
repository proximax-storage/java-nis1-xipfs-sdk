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
import io.nem.builder.BinaryTransferTransactionBuilder;
import io.nem.builder.util.JsonUtils;
import io.nem.xpx.model.BinaryTransactionEncryptedMessage;
import java.io.File;
import io.nem.xpx.model.RequestAnnounceDataSignature;
import io.nem.xpx.model.ResponseEntity;

import org.junit.Test;
import org.nem.core.crypto.KeyPair;
import org.nem.core.crypto.PrivateKey;
import org.nem.core.crypto.PublicKey;
import org.nem.core.model.Account;
import org.nem.core.model.Address;
import org.nem.core.model.MessageTypes;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DataHashApi
 */
public class DataHashApiTest {

    private final DataHashApi api = new DataHashApi();

    
    /**
     * Generates the encrypted datahash and uploads the file in the process.
     *
     * This endpoint can be used to generates the encrypted datahash and uploads the file in the process.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void generateHashAndExposeFileToNetworkUsingPOSTTest() throws ApiException {
        File file = new File("D:\\Downloads\\XARCADE SDO INFORMATION PAPER(RUS).pdf");
        String xPvkey = "8e75544a9f90253fcd880ea73b78f3bc84e1fad032c0cd1062f5694c4fc28bcd";
        String xPubkey = "d24fcd87f3d1f661a0dc15f658cbbffb51b1a13cea3ad99acf73df9b896aed94";
        String keywords = null;
        String metadata = null;
        BinaryTransactionEncryptedMessage response = api.generateHashAndExposeFileToNetworkUsingPOST(file, keywords, metadata);

        // TODO: test validations
        System.out.println(response);
        
		RequestAnnounceDataSignature requestAnnounceDataSignature = BinaryTransferTransactionBuilder
				.sender(new Account(new KeyPair(PrivateKey.fromHexString(xPvkey))))
				.recipient(new Account(Address.fromPublicKey(PublicKey.fromHexString(xPubkey))))
				.message(JsonUtils.toJson(response), MessageTypes.SECURE).buildAndSignTransaction();
		
		 PublishAndAnnounceApi publishAnnounceApi = new PublishAndAnnounceApi();
	        String string = publishAnnounceApi.announceRequestPublishDataSignatureUsingPOST(requestAnnounceDataSignature);
	        
	        
	        System.out.println(string);

    }
    
    /**
     * This endpoint can be used to generate the transaction along with the data hash with the private key signature.
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void generateHashExposeByteArrayToNetworkBuildAndSignUsingPOSTTest() throws ApiException {
        String xPvkey = "8e75544a9f90253fcd880ea73b78f3bc84e1fad032c0cd1062f5694c4fc28bcd";
        String xPubkey = "d24fcd87f3d1f661a0dc15f658cbbffb51b1a13cea3ad99acf73df9b896aed94";
        String messageType = "SECURE";
        String data = ":yehey11111:111";
        String keywords = null;
        String metadata = null;
        RequestAnnounceDataSignature response = api.generateHashExposeByteArrayToNetworkBuildAndSignUsingPOST(xPvkey, xPubkey, messageType, data, keywords, metadata);

        // TODO: test validations
        System.out.println(response);

        
        PublishAndAnnounceApi publishAnnounceApi = new PublishAndAnnounceApi();
        String string = publishAnnounceApi.announceRequestPublishDataSignatureUsingPOST(response);
        
        
        System.out.println(string);
        
    }
    
    /**
     * This endpoint can be used to generate the transaction along with the data hash with the private key signature.
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void generateHashExposeFileToNetworkBuildAndSignUsingPOSTTest() throws ApiException {
        String xPvkey = null;
        String xPubkey = null;
        String messageType = null;
        File file = null;
        String keywords = null;
        String metadata = null;
        RequestAnnounceDataSignature response = api.generateHashExposeFileToNetworkBuildAndSignUsingPOST(xPvkey, xPubkey, messageType, file, keywords, metadata);

        // TODO: test validations
    }
    
    /**
     * Generates the encrypted datahash and uploads the JSON Format String data to the P2P Storage Network.
     *
     * This endpoint can be used to generates the encrypted datahash and uploads the file in the process.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void uploadJsonDataAndGenerateHashUsingPOSTTest() throws ApiException {
        String data = "yehey";
        String keywords = null;
        String metadata = null;
        BinaryTransactionEncryptedMessage response = api.uploadJsonDataAndGenerateHashUsingPOST(data, keywords, metadata);

        // TODO: test validations
        System.out.println(response.getHash());
        String xPvkey = "8e75544a9f90253fcd880ea73b78f3bc84e1fad032c0cd1062f5694c4fc28bcd";
        String xPubkey = "d24fcd87f3d1f661a0dc15f658cbbffb51b1a13cea3ad99acf73df9b896aed94";

        // TODO: test validations
        System.out.println(response);
        
		RequestAnnounceDataSignature requestAnnounceDataSignature = BinaryTransferTransactionBuilder
				.sender(new Account(new KeyPair(PrivateKey.fromHexString(xPvkey))))
				.recipient(new Account(Address.fromPublicKey(PublicKey.fromHexString(xPubkey))))
				.message(JsonUtils.toJson(response), MessageTypes.SECURE).buildAndSignTransaction();
		
		 PublishAndAnnounceApi publishAnnounceApi = new PublishAndAnnounceApi();
	     String string = publishAnnounceApi.announceRequestPublishDataSignatureUsingPOST(requestAnnounceDataSignature);
	        
	        
	     System.out.println(string);
    }
    
}
