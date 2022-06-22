package com.boot.booking.restaurantapi.services;


import com.boot.booking.restaurantapi.exceptions.BookingExceptions;
import com.boot.booking.restaurantapi.jsons.CreateReservationRest;
import com.boot.booking.restaurantapi.jsons.ReservationRest;


public interface ReservationService {
	ReservationRest getReservationById(Long reservationId) throws BookingExceptions;
	String createReservation(CreateReservationRest CreateReservationRest) throws BookingExceptions;
	public void updateReservation(final boolean payment, String locator) throws BookingExceptions;

}
