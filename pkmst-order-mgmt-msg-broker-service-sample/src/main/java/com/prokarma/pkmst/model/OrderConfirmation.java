package com.prokarma.pkmst.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderConfirmation {
	@JsonProperty("orderPlacedConfirmationId")
	private String orderPlacedConfirmationId;
	
	@JsonProperty("paymentConfirmationId")
	private String paymentConfirmationId;
	
	@JsonProperty("dollarAmount")
	private BigDecimal dollarAmount;

	public String getOrderPlacedConfirmationId() {
		return orderPlacedConfirmationId;
	}

	public void setOrderPlacedConfirmationId(String orderPlacedConfirmationId) {
		this.orderPlacedConfirmationId = orderPlacedConfirmationId;
	}

	public String getPaymentConfirmationId() {
		return paymentConfirmationId;
	}

	public void setPaymentConfirmationId(String paymentConfirmationId) {
		this.paymentConfirmationId = paymentConfirmationId;
	}

	public BigDecimal getDollarAmount() {
		return dollarAmount;
	}

	public void setDollarAmount(BigDecimal dollarAmount) {
		this.dollarAmount = dollarAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dollarAmount == null) ? 0 : dollarAmount.hashCode());
		result = prime * result + ((orderPlacedConfirmationId == null) ? 0 : orderPlacedConfirmationId.hashCode());
		result = prime * result + ((paymentConfirmationId == null) ? 0 : paymentConfirmationId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderConfirmation other = (OrderConfirmation) obj;
		if (dollarAmount == null) {
			if (other.dollarAmount != null)
				return false;
		} else if (!dollarAmount.equals(other.dollarAmount))
			return false;
		if (orderPlacedConfirmationId == null) {
			if (other.orderPlacedConfirmationId != null)
				return false;
		} else if (!orderPlacedConfirmationId.equals(other.orderPlacedConfirmationId))
			return false;
		if (paymentConfirmationId == null) {
			if (other.paymentConfirmationId != null)
				return false;
		} else if (!paymentConfirmationId.equals(other.paymentConfirmationId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderConfirmation [orderPlacedConfirmationId=" + orderPlacedConfirmationId + ", paymentConfirmationId="
				+ paymentConfirmationId + ", dollarAmount=" + dollarAmount + "]";
	} 
	
	

}
