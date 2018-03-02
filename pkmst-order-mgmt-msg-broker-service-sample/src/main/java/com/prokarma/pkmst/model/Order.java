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
 * Order
 */

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaPKMSTServerCodegen", date = "2018-02-22T21:37:34.360Z")

public class Order {
	@JsonProperty("productId")
	private Integer productId = null;

	@JsonProperty("quantity")
	private Integer quantity = null;

	@JsonProperty("customerId")
	private Integer customerId = null;

	@JsonProperty("paymentAccountId")
	private Integer paymentAccountId = null;

	@JsonProperty("paymentAmount")
	private BigDecimal paymentAmount = null;
	
	@JsonProperty("sessionId")
	private String sessionId = null;

	public Order productId(Integer productId) {
		this.productId = productId;
		return this;
	}

	/**
	 * Get productId
	 * 
	 * @return productId
	 **/
	@ApiModelProperty(value = "")
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Order quantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	/**
	 * Get quantity
	 * 
	 * @return quantity
	 **/
	@ApiModelProperty(value = "")
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Order customerId(Integer customerId) {
		this.customerId = customerId;
		return this;
	}

	/**
	 * Get customerId
	 * 
	 * @return customerId
	 **/
	@ApiModelProperty(value = "")
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Order paymentAccountId(Integer paymentAccountId) {
		this.paymentAccountId = paymentAccountId;
		return this;
	}

	/**
	 * Get paymentAccountId
	 * 
	 * @return paymentAccountId
	 **/
	@ApiModelProperty(value = "")
	public Integer getPaymentAccountId() {
		return paymentAccountId;
	}

	public void setPaymentAccountId(Integer paymentAccountId) {
		this.paymentAccountId = paymentAccountId;
	}

	public Order paymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
		return this;
	}

	/**
	 * Get paymentAmount
	 * 
	 * @return paymentAmount
	 **/
	@ApiModelProperty(value = "")
	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Order order = (Order) o;
		return Objects.equals(this.productId, order.productId) && Objects.equals(this.quantity, order.quantity)
				&& Objects.equals(this.customerId, order.customerId)
				&& Objects.equals(this.paymentAccountId, order.paymentAccountId)
				&& Objects.equals(this.paymentAmount, order.paymentAmount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, quantity, customerId, paymentAccountId, paymentAmount);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Order {\n");

		sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
		sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
		sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
		sb.append("    paymentAccountId: ").append(toIndentedString(paymentAccountId)).append("\n");
		sb.append("    paymentAmount: ").append(toIndentedString(paymentAmount)).append("\n");
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
