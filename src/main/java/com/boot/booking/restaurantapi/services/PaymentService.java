package com.boot.booking.restaurantapi.services;

import com.boot.booking.restaurantapi.exceptions.BookingExceptions;
import com.boot.booking.restaurantapi.jsons.PaymentConfirmRest;
import com.boot.booking.restaurantapi.jsons.PaymentIntentRest;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface PaymentService {
	public PaymentIntent paymentIntent (PaymentIntentRest paymentIntentRest) throws StripeException;
	public PaymentIntent paymentConfirm(PaymentConfirmRest paymentConfirmRest) throws StripeException, BookingExceptions;
	public PaymentIntent paymentCancel(String paymentId) throws StripeException;

}
