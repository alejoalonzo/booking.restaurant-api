package com.boot.booking.restaurantapi.services;

import com.boot.booking.restaurantapi.exceptions.BookingExceptions;

public interface CancelReservationService {
	
	public String deleteReservation(String locator) throws BookingExceptions;
	
}
