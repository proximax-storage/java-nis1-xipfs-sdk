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
import io.nem.xpx.model.AccountInfo;
import io.nem.xpx.model.AccountMetaData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * AccountMetaDataPair
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-20T01:21:50.104-04:00")
public class AccountMetaDataPair {
  @SerializedName("entity")
  private AccountInfo entity = null;

  @SerializedName("metaData")
  private AccountMetaData metaData = null;

  public AccountMetaDataPair entity(AccountInfo entity) {
    this.entity = entity;
    return this;
  }

   /**
   * Get entity
   * @return entity
  **/
  @ApiModelProperty(value = "")
  public AccountInfo getEntity() {
    return entity;
  }

  public void setEntity(AccountInfo entity) {
    this.entity = entity;
  }

  public AccountMetaDataPair metaData(AccountMetaData metaData) {
    this.metaData = metaData;
    return this;
  }

   /**
   * Get metaData
   * @return metaData
  **/
  @ApiModelProperty(value = "")
  public AccountMetaData getMetaData() {
    return metaData;
  }

  public void setMetaData(AccountMetaData metaData) {
    this.metaData = metaData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountMetaDataPair accountMetaDataPair = (AccountMetaDataPair) o;
    return Objects.equals(this.entity, accountMetaDataPair.entity) &&
        Objects.equals(this.metaData, accountMetaDataPair.metaData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entity, metaData);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountMetaDataPair {\n");
    
    sb.append("    entity: ").append(toIndentedString(entity)).append("\n");
    sb.append("    metaData: ").append(toIndentedString(metaData)).append("\n");
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

