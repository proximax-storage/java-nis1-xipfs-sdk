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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;


/**
 * ResponseEntity.
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-03-26T23:27:01.504-04:00")
public class ResponseEntity {
  
  /** The body. */
  @SerializedName("body")
  private Object body = null;

  /**
   * Gets or Sets statusCode.
   */
  @JsonAdapter(StatusCodeEnum.Adapter.class)
  public enum StatusCodeEnum {
    
    /** The  100. */
    _100("100"),
    
    /** The  101. */
    _101("101"),
    
    /** The  102. */
    _102("102"),
    
    /** The  103. */
    _103("103"),
    
    /** The  200. */
    _200("200"),
    
    /** The  201. */
    _201("201"),
    
    /** The  202. */
    _202("202"),
    
    /** The  203. */
    _203("203"),
    
    /** The  204. */
    _204("204"),
    
    /** The  205. */
    _205("205"),
    
    /** The  206. */
    _206("206"),
    
    /** The  207. */
    _207("207"),
    
    /** The  208. */
    _208("208"),
    
    /** The  226. */
    _226("226"),
    
    /** The  300. */
    _300("300"),
    
    /** The  301. */
    _301("301"),
    
    /** The  302. */
    _302("302"),
    
    /** The  303. */
    _303("303"),
    
    /** The  304. */
    _304("304"),
    
    /** The  305. */
    _305("305"),
    
    /** The  307. */
    _307("307"),
    
    /** The  308. */
    _308("308"),
    
    /** The  400. */
    _400("400"),
    
    /** The  401. */
    _401("401"),
    
    /** The  402. */
    _402("402"),
    
    /** The  403. */
    _403("403"),
    
    /** The  404. */
    _404("404"),
    
    /** The  405. */
    _405("405"),
    
    /** The  406. */
    _406("406"),
    
    /** The  407. */
    _407("407"),
    
    /** The  408. */
    _408("408"),
    
    /** The  409. */
    _409("409"),
    
    /** The  410. */
    _410("410"),
    
    /** The  411. */
    _411("411"),
    
    /** The  412. */
    _412("412"),
    
    /** The  413. */
    _413("413"),
    
    /** The  414. */
    _414("414"),
    
    /** The  415. */
    _415("415"),
    
    /** The  416. */
    _416("416"),
    
    /** The  417. */
    _417("417"),
    
    /** The  418. */
    _418("418"),
    
    /** The  419. */
    _419("419"),
    
    /** The  420. */
    _420("420"),
    
    /** The  421. */
    _421("421"),
    
    /** The  422. */
    _422("422"),
    
    /** The  423. */
    _423("423"),
    
    /** The  424. */
    _424("424"),
    
    /** The  426. */
    _426("426"),
    
    /** The  428. */
    _428("428"),
    
    /** The  429. */
    _429("429"),
    
    /** The  431. */
    _431("431"),
    
    /** The  451. */
    _451("451"),
    
    /** The  500. */
    _500("500"),
    
    /** The  501. */
    _501("501"),
    
    /** The  502. */
    _502("502"),
    
    /** The  503. */
    _503("503"),
    
    /** The  504. */
    _504("504"),
    
    /** The  505. */
    _505("505"),
    
    /** The  506. */
    _506("506"),
    
    /** The  507. */
    _507("507"),
    
    /** The  508. */
    _508("508"),
    
    /** The  509. */
    _509("509"),
    
    /** The  510. */
    _510("510"),
    
    /** The  511. */
    _511("511");

    /** The value. */
    private String value;

    /**
     * Instantiates a new status code enum.
     *
     * @param value the value
     */
    StatusCodeEnum(String value) {
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
     * @return the status code enum
     */
    public static StatusCodeEnum fromValue(String text) {
      for (StatusCodeEnum b : StatusCodeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    /**
     * The Class Adapter.
     */
    public static class Adapter extends TypeAdapter<StatusCodeEnum> {
      
      /* (non-Javadoc)
       * @see com.google.gson.TypeAdapter#write(com.google.gson.stream.JsonWriter, java.lang.Object)
       */
      @Override
      public void write(final JsonWriter jsonWriter, final StatusCodeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      /* (non-Javadoc)
       * @see com.google.gson.TypeAdapter#read(com.google.gson.stream.JsonReader)
       */
      @Override
      public StatusCodeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StatusCodeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  /** The status code. */
  @SerializedName("statusCode")
  private StatusCodeEnum statusCode = null;

  /** The status code value. */
  @SerializedName("statusCodeValue")
  private Integer statusCodeValue = null;

  /**
   * Body.
   *
   * @param body the body
   * @return the response entity
   */
  public ResponseEntity body(Object body) {
    this.body = body;
    return this;
  }

   /**
    * Get body.
    *
    * @return body
    */
  @ApiModelProperty(value = "")
  public Object getBody() {
    return body;
  }

  /**
   * Sets the body.
   *
   * @param body the new body
   */
  public void setBody(Object body) {
    this.body = body;
  }

  /**
   * Status code.
   *
   * @param statusCode the status code
   * @return the response entity
   */
  public ResponseEntity statusCode(StatusCodeEnum statusCode) {
    this.statusCode = statusCode;
    return this;
  }

   /**
    * Get statusCode.
    *
    * @return statusCode
    */
  @ApiModelProperty(value = "")
  public StatusCodeEnum getStatusCode() {
    return statusCode;
  }

  /**
   * Sets the status code.
   *
   * @param statusCode the new status code
   */
  public void setStatusCode(StatusCodeEnum statusCode) {
    this.statusCode = statusCode;
  }

  /**
   * Status code value.
   *
   * @param statusCodeValue the status code value
   * @return the response entity
   */
  public ResponseEntity statusCodeValue(Integer statusCodeValue) {
    this.statusCodeValue = statusCodeValue;
    return this;
  }

   /**
    * Get statusCodeValue.
    *
    * @return statusCodeValue
    */
  @ApiModelProperty(value = "")
  public Integer getStatusCodeValue() {
    return statusCodeValue;
  }

  /**
   * Sets the status code value.
   *
   * @param statusCodeValue the new status code value
   */
  public void setStatusCodeValue(Integer statusCodeValue) {
    this.statusCodeValue = statusCodeValue;
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
    ResponseEntity responseEntity = (ResponseEntity) o;
    return Objects.equals(this.body, responseEntity.body) &&
        Objects.equals(this.statusCode, responseEntity.statusCode) &&
        Objects.equals(this.statusCodeValue, responseEntity.statusCodeValue);
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return Objects.hash(body, statusCode, statusCodeValue);
  }


  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseEntity {\n");
    
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
    sb.append("    statusCodeValue: ").append(toIndentedString(statusCodeValue)).append("\n");
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

