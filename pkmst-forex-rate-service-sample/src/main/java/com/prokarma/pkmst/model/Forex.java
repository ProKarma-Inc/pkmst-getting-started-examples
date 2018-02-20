package com.prokarma.pkmst.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
/**
 * Response class to be returned by Api
 * @author pkmst
 *
 */
/**
 * Forex
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaPKMSTServerCodegen", date = "2018-02-20T12:58:06.831Z")

public class Forex   {
  @JsonProperty("ticker")
  private String ticker = null;

  @JsonProperty("highPrice")
  private BigDecimal highPrice = null;

  @JsonProperty("lowPrice")
  private BigDecimal lowPrice = null;

  @JsonProperty("openingPrice")
  private BigDecimal openingPrice = null;

  @JsonProperty("closingPrice")
  private BigDecimal closingPrice = null;

  public Forex ticker(String ticker) {
    this.ticker = ticker;
    return this;
  }

   /**
   * Get ticker
   * @return ticker
  **/
  @ApiModelProperty(value = "")
  public String getTicker() {
    return ticker;
  }

  public void setTicker(String ticker) {
    this.ticker = ticker;
  }

  public Forex highPrice(BigDecimal highPrice) {
    this.highPrice = highPrice;
    return this;
  }

   /**
   * Get highPrice
   * @return highPrice
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getHighPrice() {
    return highPrice;
  }

  public void setHighPrice(BigDecimal highPrice) {
    this.highPrice = highPrice;
  }

  public Forex lowPrice(BigDecimal lowPrice) {
    this.lowPrice = lowPrice;
    return this;
  }

   /**
   * Get lowPrice
   * @return lowPrice
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getLowPrice() {
    return lowPrice;
  }

  public void setLowPrice(BigDecimal lowPrice) {
    this.lowPrice = lowPrice;
  }

  public Forex openingPrice(BigDecimal openingPrice) {
    this.openingPrice = openingPrice;
    return this;
  }

   /**
   * Get openingPrice
   * @return openingPrice
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getOpeningPrice() {
    return openingPrice;
  }

  public void setOpeningPrice(BigDecimal openingPrice) {
    this.openingPrice = openingPrice;
  }

  public Forex closingPrice(BigDecimal closingPrice) {
    this.closingPrice = closingPrice;
    return this;
  }

   /**
   * Get closingPrice
   * @return closingPrice
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getClosingPrice() {
    return closingPrice;
  }

  public void setClosingPrice(BigDecimal closingPrice) {
    this.closingPrice = closingPrice;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Forex forex = (Forex) o;
    return Objects.equals(this.ticker, forex.ticker) &&
        Objects.equals(this.highPrice, forex.highPrice) &&
        Objects.equals(this.lowPrice, forex.lowPrice) &&
        Objects.equals(this.openingPrice, forex.openingPrice) &&
        Objects.equals(this.closingPrice, forex.closingPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ticker, highPrice, lowPrice, openingPrice, closingPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Forex {\n");
    
    sb.append("    ticker: ").append(toIndentedString(ticker)).append("\n");
    sb.append("    highPrice: ").append(toIndentedString(highPrice)).append("\n");
    sb.append("    lowPrice: ").append(toIndentedString(lowPrice)).append("\n");
    sb.append("    openingPrice: ").append(toIndentedString(openingPrice)).append("\n");
    sb.append("    closingPrice: ").append(toIndentedString(closingPrice)).append("\n");
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

