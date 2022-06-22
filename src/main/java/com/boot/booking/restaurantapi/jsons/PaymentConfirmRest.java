package com.boot.booking.restaurantapi.jsons;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentConfirmRest {
	private String locator;
	
	private String paymentId;
	
	private String name;
	
	private String email;

	public final String getPaymentId() {
		return paymentId;
	}

	public final void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final String getLocator() {
		return locator;
	}

	public final void setLocator(String locator) {
		this.locator = locator;
	}
}
