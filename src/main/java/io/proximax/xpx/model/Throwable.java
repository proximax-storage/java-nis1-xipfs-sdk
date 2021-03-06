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
 * Contact: alvin.reyes@botmill.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.proximax.xpx.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;




/**
 * Throwable.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-07T03:37:57.794-04:00")
public class Throwable {
  
  /** The cause. */
  @SerializedName("cause")
  private Throwable cause = null;

  /** The localized message. */
  @SerializedName("localizedMessage")
  private String localizedMessage = null;

  /** The message. */
  @SerializedName("message")
  private String message = null;

  /** The stack trace. */
  @SerializedName("stackTrace")
  private List<StackTraceElement> stackTrace = null;

  /** The suppressed. */
  @SerializedName("suppressed")
  private List<Throwable> suppressed = null;

  /**
   * Cause.
   *
   * @param cause the cause
   * @return the throwable
   */
  public Throwable cause(Throwable cause) {
    this.cause = cause;
    return this;
  }

   /**
    * Get cause.
    *
    * @return cause
    */
  @ApiModelProperty(value = "")
  public Throwable getCause() {
    return cause;
  }

  /**
   * Sets the cause.
   *
   * @param cause the new cause
   */
  public void setCause(Throwable cause) {
    this.cause = cause;
  }

  /**
   * Localized message.
   *
   * @param localizedMessage the localized message
   * @return the throwable
   */
  public Throwable localizedMessage(String localizedMessage) {
    this.localizedMessage = localizedMessage;
    return this;
  }

   /**
    * Get localizedMessage.
    *
    * @return localizedMessage
    */
  @ApiModelProperty(value = "")
  public String getLocalizedMessage() {
    return localizedMessage;
  }

  /**
   * Sets the localized message.
   *
   * @param localizedMessage the new localized message
   */
  public void setLocalizedMessage(String localizedMessage) {
    this.localizedMessage = localizedMessage;
  }

  /**
   * Message.
   *
   * @param message the message
   * @return the throwable
   */
  public Throwable message(String message) {
    this.message = message;
    return this;
  }

   /**
    * Get message.
    *
    * @return message
    */
  @ApiModelProperty(value = "")
  public String getMessage() {
    return message;
  }

  /**
   * Sets the message.
   *
   * @param message the new message
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * Stack trace.
   *
   * @param stackTrace the stack trace
   * @return the throwable
   */
  public Throwable stackTrace(List<StackTraceElement> stackTrace) {
    this.stackTrace = stackTrace;
    return this;
  }

  /**
   * Adds the stack trace item.
   *
   * @param stackTraceItem the stack trace item
   * @return the throwable
   */
  public Throwable addStackTraceItem(StackTraceElement stackTraceItem) {
    if (this.stackTrace == null) {
      this.stackTrace = new ArrayList<StackTraceElement>();
    }
    this.stackTrace.add(stackTraceItem);
    return this;
  }

   /**
    * Get stackTrace.
    *
    * @return stackTrace
    */
  @ApiModelProperty(value = "")
  public List<StackTraceElement> getStackTrace() {
    return stackTrace;
  }

  /**
   * Sets the stack trace.
   *
   * @param stackTrace the new stack trace
   */
  public void setStackTrace(List<StackTraceElement> stackTrace) {
    this.stackTrace = stackTrace;
  }

  /**
   * Suppressed.
   *
   * @param suppressed the suppressed
   * @return the throwable
   */
  public Throwable suppressed(List<Throwable> suppressed) {
    this.suppressed = suppressed;
    return this;
  }

  /**
   * Adds the suppressed item.
   *
   * @param suppressedItem the suppressed item
   * @return the throwable
   */
  public Throwable addSuppressedItem(Throwable suppressedItem) {
    if (this.suppressed == null) {
      this.suppressed = new ArrayList<Throwable>();
    }
    this.suppressed.add(suppressedItem);
    return this;
  }

   /**
    * Get suppressed.
    *
    * @return suppressed
    */
  @ApiModelProperty(value = "")
  public List<Throwable> getSuppressed() {
    return suppressed;
  }

  /**
   * Sets the suppressed.
   *
   * @param suppressed the new suppressed
   */
  public void setSuppressed(List<Throwable> suppressed) {
    this.suppressed = suppressed;
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
    Throwable throwable = (Throwable) o;
    return Objects.equals(this.cause, throwable.cause) &&
        Objects.equals(this.localizedMessage, throwable.localizedMessage) &&
        Objects.equals(this.message, throwable.message) &&
        Objects.equals(this.stackTrace, throwable.stackTrace) &&
        Objects.equals(this.suppressed, throwable.suppressed);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(cause, localizedMessage, message, stackTrace, suppressed);
  }


  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Throwable {\n");
    
    sb.append("    cause: ").append(toIndentedString(cause)).append("\n");
    sb.append("    localizedMessage: ").append(toIndentedString(localizedMessage)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    stackTrace: ").append(toIndentedString(stackTrace)).append("\n");
    sb.append("    suppressed: ").append(toIndentedString(suppressed)).append("\n");
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

