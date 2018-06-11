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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




/**
 * AccountMetaData.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-25T23:45:59.064-04:00")
public class AccountMetaData {
  
  /** The cosignatories. */
  @SerializedName("cosignatories")
  private List<AccountInfo> cosignatories = null;

  /** The cosignatory of. */
  @SerializedName("cosignatoryOf")
  private List<AccountInfo> cosignatoryOf = null;

  /**
   * Gets or Sets remoteStatus.
   */
  @JsonAdapter(RemoteStatusEnum.Adapter.class)
  public enum RemoteStatusEnum {
    
    /** The remote. */
    REMOTE("REMOTE"),
    
    /** The activating. */
    ACTIVATING("ACTIVATING"),
    
    /** The active. */
    ACTIVE("ACTIVE"),
    
    /** The deactivating. */
    DEACTIVATING("DEACTIVATING"),
    
    /** The inactive. */
    INACTIVE("INACTIVE");

    /** The value. */
    private String value;

    /**
     * Instantiates a new remote status enum.
     *
     * @param value the value
     */
    RemoteStatusEnum(String value) {
      this.value = value;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
      return value;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
      return String.valueOf(value);
    }

    /**
     * From value.
     *
     * @param text the text
     * @return the remote status enum
     */
    public static RemoteStatusEnum fromValue(String text) {
      for (RemoteStatusEnum b : RemoteStatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    /**
     * The Class Adapter.
     */
    public static class Adapter extends TypeAdapter<RemoteStatusEnum> {
      
      /* (non-Javadoc)
       * @see com.google.gson.TypeAdapter#write(com.google.gson.stream.JsonWriter, java.lang.Object)
       */
      @Override
      public void write(final JsonWriter jsonWriter, final RemoteStatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      /* (non-Javadoc)
       * @see com.google.gson.TypeAdapter#read(com.google.gson.stream.JsonReader)
       */
      @Override
      public RemoteStatusEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return RemoteStatusEnum.fromValue(String.valueOf(value));
      }
    }
  }

  /** The remote status. */
  @SerializedName("remoteStatus")
  private RemoteStatusEnum remoteStatus = null;

  /**
   * Gets or Sets status.
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    
    /** The unknown. */
    UNKNOWN("UNKNOWN"),
    
    /** The locked. */
    LOCKED("LOCKED"),
    
    /** The unlocked. */
    UNLOCKED("UNLOCKED");

    /** The value. */
    private String value;

    /**
     * Instantiates a new status enum.
     *
     * @param value the value
     */
    StatusEnum(String value) {
      this.value = value;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
      return value;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
      return String.valueOf(value);
    }

    /**
     * From value.
     *
     * @param text the text
     * @return the status enum
     */
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    /**
     * The Class Adapter.
     */
    public static class Adapter extends TypeAdapter<StatusEnum> {
      
      /* (non-Javadoc)
       * @see com.google.gson.TypeAdapter#write(com.google.gson.stream.JsonWriter, java.lang.Object)
       */
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      /* (non-Javadoc)
       * @see com.google.gson.TypeAdapter#read(com.google.gson.stream.JsonReader)
       */
      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StatusEnum.fromValue(String.valueOf(value));
      }
    }
  }

  /** The status. */
  @SerializedName("status")
  private StatusEnum status = null;

  /**
   * Cosignatories.
   *
   * @param cosignatories the cosignatories
   * @return the account meta data
   */
  public AccountMetaData cosignatories(List<AccountInfo> cosignatories) {
    this.cosignatories = cosignatories;
    return this;
  }

  /**
   * Adds the cosignatories item.
   *
   * @param cosignatoriesItem the cosignatories item
   * @return the account meta data
   */
  public AccountMetaData addCosignatoriesItem(AccountInfo cosignatoriesItem) {
    if (this.cosignatories == null) {
      this.cosignatories = new ArrayList<AccountInfo>();
    }
    this.cosignatories.add(cosignatoriesItem);
    return this;
  }

   /**
    * Get cosignatories.
    *
    * @return cosignatories
    */
  @ApiModelProperty(value = "")
  public List<AccountInfo> getCosignatories() {
    return cosignatories;
  }

  /**
   * Sets the cosignatories.
   *
   * @param cosignatories the new cosignatories
   */
  public void setCosignatories(List<AccountInfo> cosignatories) {
    this.cosignatories = cosignatories;
  }

  /**
   * Cosignatory of.
   *
   * @param cosignatoryOf the cosignatory of
   * @return the account meta data
   */
  public AccountMetaData cosignatoryOf(List<AccountInfo> cosignatoryOf) {
    this.cosignatoryOf = cosignatoryOf;
    return this;
  }

  /**
   * Adds the cosignatory of item.
   *
   * @param cosignatoryOfItem the cosignatory of item
   * @return the account meta data
   */
  public AccountMetaData addCosignatoryOfItem(AccountInfo cosignatoryOfItem) {
    if (this.cosignatoryOf == null) {
      this.cosignatoryOf = new ArrayList<AccountInfo>();
    }
    this.cosignatoryOf.add(cosignatoryOfItem);
    return this;
  }

   /**
    * Get cosignatoryOf.
    *
    * @return cosignatoryOf
    */
  @ApiModelProperty(value = "")
  public List<AccountInfo> getCosignatoryOf() {
    return cosignatoryOf;
  }

  /**
   * Sets the cosignatory of.
   *
   * @param cosignatoryOf the new cosignatory of
   */
  public void setCosignatoryOf(List<AccountInfo> cosignatoryOf) {
    this.cosignatoryOf = cosignatoryOf;
  }

  /**
   * Remote status.
   *
   * @param remoteStatus the remote status
   * @return the account meta data
   */
  public AccountMetaData remoteStatus(RemoteStatusEnum remoteStatus) {
    this.remoteStatus = remoteStatus;
    return this;
  }

   /**
    * Get remoteStatus.
    *
    * @return remoteStatus
    */
  @ApiModelProperty(value = "")
  public RemoteStatusEnum getRemoteStatus() {
    return remoteStatus;
  }

  /**
   * Sets the remote status.
   *
   * @param remoteStatus the new remote status
   */
  public void setRemoteStatus(RemoteStatusEnum remoteStatus) {
    this.remoteStatus = remoteStatus;
  }

  /**
   * Status.
   *
   * @param status the status
   * @return the account meta data
   */
  public AccountMetaData status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
    * Get status.
    *
    * @return status
    */
  @ApiModelProperty(value = "")
  public StatusEnum getStatus() {
    return status;
  }

  /**
   * Sets the status.
   *
   * @param status the new status
   */
  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
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

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(cosignatories, cosignatoryOf, remoteStatus, status);
  }


  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
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
   *
   * @param o the o
   * @return the string
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}

