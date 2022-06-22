package com.boot.booking.restaurantapi.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.boot.booking.restaurantapi.exceptions.BookingExceptions;
import com.boot.booking.restaurantapi.jsons.PaymentConfirmRest;
import com.boot.booking.restaurantapi.jsons.PaymentIntentRest;
import com.boot.booking.restaurantapi.services.EmailService;
import com.boot.booking.restaurantapi.services.PaymentService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ReservationServiceImpl reservationServiceImpl;

	@Value("${stripe.key.secret}")
	String secretKey;

	public enum Currency {
		USD, EUR
	}

	public PaymentIntent paymentIntent(PaymentIntentRest paymentIntentRest) throws StripeException {

		Stripe.apiKey = secretKey;
		Map<String, Object> params = new HashMap<>();
		params.put("currency", Currency.USD);
		params.put("amount", paymentIntentRest.getPrice());
		params.put("description", paymentIntentRest.getDescription());
		List<Object> paymentMethodTypes = new ArrayList<>();
		paymentMethodTypes.add("card");

		params.put("payment_method_types", paymentMethodTypes);

		return PaymentIntent.create(params);
	}

	public PaymentIntent paymentConfirm(PaymentConfirmRest paymentConfirmRest) throws StripeException, BookingExceptions {

		Stripe.apiKey = secretKey;
		PaymentIntent paymentIntent = PaymentIntent.retrieve(paymentConfirmRest.getPaymentId());
		Map<String, Object> params = new HashMap<>();
		params.put("payment_method", "pm_card_visa");
		paymentIntent.confirm(params);

		reservationServiceImpl.updateReservation(true, paymentConfirmRest.getLocator());
		emailService.processSendEmail(paymentConfirmRest.getEmail(), "PAYMENT", paymentConfirmRest.getName());
		
		return paymentIntent;
	}

	public PaymentIntent paymentCancel(String paymentId) throws StripeException {

		Stripe.apiKey = secretKey;
		PaymentIntent paymentIntent = PaymentIntent.retrieve(paymentId);

		paymentIntent.cancel();

		return paymentIntent;
	}

}
