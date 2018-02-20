package com.prokarma.pkmst.model;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
/**
 * Response class to be returned by Api
 * @author pkmst
 *
 */
/**
 * Stock
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaPKMSTServerCodegen", date = "2018-02-15T21:21:34.533Z")

public class Stock   {
  @JsonProperty("ticker")
  private String ticker = null;

  @JsonProperty("exchange")
  private String exchange = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("highPrice")
  private BigDecimal highPrice = null;

  @JsonProperty("lowPrice")
  private BigDecimal lowPrice = null;

  @JsonProperty("openingPrice")
  private BigDecimal openingPrice = null;

  @JsonProperty("closingPrice")
  private BigDecimal closingPrice = null;

  public Stock ticker(String ticker) {
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

  public Stock exchange(String exchange) {
    this.exchange = exchange;
    return this;
  }

   /**
   * Get exchange
   * @return exchange
  **/
  @ApiModelProperty(value = "")
  public String getExchange() {
    return exchange;
  }

  public void setExchange(String exchange) {
    this.exchange = exchange;
  }

  public Stock name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Stock description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Stock highPrice(BigDecimal highPrice) {
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

  public Stock lowPrice(BigDecimal lowPrice) {
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

  public Stock openingPrice(BigDecimal openingPrice) {
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

  public Stock closingPrice(BigDecimal closingPrice) {
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
    Stock stock = (Stock) o;
    return Objects.equals(this.ticker, stock.ticker) &&
        Objects.equals(this.exchange, stock.exchange) &&
        Objects.equals(this.name, stock.name) &&
        Objects.equals(this.description, stock.description) &&
        Objects.equals(this.highPrice, stock.highPrice) &&
        Objects.equals(this.lowPrice, stock.lowPrice) &&
        Objects.equals(this.openingPrice, stock.openingPrice) &&
        Objects.equals(this.closingPrice, stock.closingPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ticker, exchange, name, description, highPrice, lowPrice, openingPrice, closingPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Stock {\n");
    
    sb.append("    ticker: ").append(toIndentedString(ticker)).append("\n");
    sb.append("    exchange: ").append(toIndentedString(exchange)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

