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


package io.nem.xpx.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.nem.xpx.model.AccountInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * AccountMetaData
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-02-24T22:58:22.311-05:00")
public class AccountMetaData {
  @SerializedName("cosignatories")
  private List<AccountInfo> cosignatories = null;

  @SerializedName("cosignatoryOf")
  private List<AccountInfo> cosignatoryOf = null;

  /**
   * Gets or Sets remoteStatus
   */
  @JsonAdapter(RemoteStatusEnum.Adapter.class)
  public enum RemoteStatusEnum {
    REMOTE("REMOTE"),
    
    ACTIVATING("ACTIVATING"),
    
    ACTIVE("ACTIVE"),
    
    DEACTIVATING("DEACTIVATING"),
    
    INACTIVE("INACTIVE");

    private String value;

    RemoteStatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RemoteStatusEnum fromValue(String text) {
      for (RemoteStatusEnum b : RemoteStatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<RemoteStatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RemoteStatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RemoteStatusEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return RemoteStatusEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("remoteStatus")
  private RemoteStatusEnum remoteStatus = null;

  /**
   * Gets or Sets status
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    UNKNOWN("UNKNOWN"),
    
    LOCKED("LOCKED"),
    
    UNLOCKED("UNLOCKED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StatusEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("status")
  private StatusEnum status = null;

  public AccountMetaData cosignatories(List<AccountInfo> cosignatories) {
    this.cosignatories = cosignatories;
    return this;
  }

  public AccountMetaData addCosignatoriesItem(AccountInfo cosignatoriesItem) {
    if (this.cosignatories == null) {
      this.cosignatories = new ArrayList<AccountInfo>();
    }
    this.cosignatories.add(cosignatoriesItem);
    return this;
  }

   /**
   * Get cosignatories
   * @return cosignatories
  **/
  @ApiModelProperty(value = "")
  public List<AccountInfo> getCosignatories() {
    return cosignatories;
  }

  public void setCosignatories(List<AccountInfo> cosignatories) {
    this.cosignatories = cosignatories;
  }

  public AccountMetaData cosignatoryOf(List<AccountInfo> cosignatoryOf) {
    this.cosignatoryOf = cosignatoryOf;
    return this;
  }

  public AccountMetaData addCosignatoryOfItem(AccountInfo cosignatoryOfItem) {
    if (this.cosignatoryOf == null) {
      this.cosignatoryOf = new ArrayList<AccountInfo>();
    }
    this.cosignatoryOf.add(cosignatoryOfItem);
    return this;
  }

   /**
   * Get cosignatoryOf
   * @return cosignatoryOf
  **/
  @ApiModelProperty(value = "")
  public List<AccountInfo> getCosignatoryOf() {
    return cosignatoryOf;
  }

  public void setCosignatoryOf(List<AccountInfo> cosignatoryOf) {
    this.cosignatoryOf = cosignatoryOf;
  }

  public AccountMetaData remoteStatus(RemoteStatusEnum remoteStatus) {
    this.remoteStatus = remoteStatus;
    return this;
  }

   /**
   * Get remoteStatus
   * @return remoteStatus
  **/
  @ApiModelProperty(value = "")
  public RemoteStatusEnum getRemoteStatus() {
    return remoteStatus;
  }

  public void setRemoteStatus(RemoteStatusEnum remoteStatus) {
    this.remoteStatus = remoteStatus;
  }

  public AccountMetaData status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountMetaData accountMetaData = (AccountMetaData) o;
    return Objects.equals(this.cosignatories, accountMetaData.cosignatories) &&
        Objects.equals(this.cosignatoryOf, accountMetaData.cosignatoryOf) &&
        Objects.equals(this.remoteStatus, accountMetaData.remoteStatus) &&
        Objects.equals(this.status, accountMetaData.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cosignatories, cosignatoryOf, remoteStatus, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountMetaData {\n");
    
    sb.append("    cosignatories: ").append(toIndentedString(cosignatories)).append("\n");
    sb.append("    cosignatoryOf: ").append(toIndentedString(cosignatoryOf)).append("\n");
    sb.append("    remoteStatus: ").append(toIndentedString(remoteStatus)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

