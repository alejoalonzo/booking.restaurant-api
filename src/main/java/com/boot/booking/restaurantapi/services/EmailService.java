package com.boot.booking.restaurantapi.services;

import com.boot.booking.restaurantapi.exceptions.BookingExceptions;

public interface EmailService {
	public String processSendEmail(final String receiver,  String templateType, 
														String currentName)throws BookingExceptions;
}
