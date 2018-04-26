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


package io.nem.xpx.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * NodeInfo
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-25T21:14:06.723-04:00")
public class NodeInfo {
  @SerializedName("contextUri")
  private String contextUri = null;

  @SerializedName("nemAddress")
  private String nemAddress = null;

  @SerializedName("network")
  private String network = null;

  @SerializedName("networkAddress")
  private String networkAddress = null;

  @SerializedName("networkPort")
  private String networkPort = null;

  @SerializedName("peerId")
  private String peerId = null;

  public NodeInfo contextUri(String contextUri) {
    this.contextUri = contextUri;
    return this;
  }

   /**
   * Get contextUri
   * @return contextUri
  **/
  @ApiModelProperty(value = "")
  public String getContextUri() {
    return contextUri;
  }

  public void setContextUri(String contextUri) {
    this.contextUri = contextUri;
  }

  public NodeInfo nemAddress(String nemAddress) {
    this.nemAddress = nemAddress;
    return this;
  }

   /**
   * Get nemAddress
   * @return nemAddress
  **/
  @ApiModelProperty(value = "")
  public String getNemAddress() {
    return nemAddress;
  }

  public void setNemAddress(String nemAddress) {
    this.nemAddress = nemAddress;
  }

  public NodeInfo network(String network) {
    this.network = network;
    return this;
  }

   /**
   * Get network
   * @return network
  **/
  @ApiModelProperty(value = "")
  public String getNetwork() {
    return network;
  }

  public void setNetwork(String network) {
    this.network = network;
  }

  public NodeInfo networkAddress(String networkAddress) {
    this.networkAddress = networkAddress;
    return this;
  }

   /**
   * Get networkAddress
   * @return networkAddress
  **/
  @ApiModelProperty(value = "")
  public String getNetworkAddress() {
    return networkAddress;
  }

  public void setNetworkAddress(String networkAddress) {
    this.networkAddress = networkAddress;
  }

  public NodeInfo networkPort(String networkPort) {
    this.networkPort = networkPort;
    return this;
  }

   /**
   * Get networkPort
   * @return networkPort
  **/
  @ApiModelProperty(value = "")
  public String getNetworkPort() {
    return networkPort;
  }

  public void setNetworkPort(String networkPort) {
    this.networkPort = networkPort;
  }

  public NodeInfo peerId(String peerId) {
    this.peerId = peerId;
    return this;
  }

   /**
   * Get peerId
   * @return peerId
  **/
  @ApiModelProperty(value = "")
  public String getPeerId() {
    return peerId;
  }

  public void setPeerId(String peerId) {
    this.peerId = peerId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NodeInfo nodeInfo = (NodeInfo) o;
    return Objects.equals(this.contextUri, nodeInfo.contextUri) &&
        Objects.equals(this.nemAddress, nodeInfo.nemAddress) &&
        Objects.equals(this.network, nodeInfo.network) &&
        Objects.equals(this.networkAddress, nodeInfo.networkAddress) &&
        Objects.equals(this.networkPort, nodeInfo.networkPort) &&
        Objects.equals(this.peerId, nodeInfo.peerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contextUri, nemAddress, network, networkAddress, networkPort, peerId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NodeInfo {\n");
    
    sb.append("    contextUri: ").append(toIndentedString(contextUri)).append("\n");
    sb.append("    nemAddress: ").append(toIndentedString(nemAddress)).append("\n");
    sb.append("    network: ").append(toIndentedString(network)).append("\n");
    sb.append("    networkAddress: ").append(toIndentedString(networkAddress)).append("\n");
    sb.append("    networkPort: ").append(toIndentedString(networkPort)).append("\n");
    sb.append("    peerId: ").append(toIndentedString(peerId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}

