package com.boot.booking.restaurantapi.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.boot.booking.restaurantapi.exceptions.BookingExceptions;
import com.boot.booking.restaurantapi.exceptions.InternalServerErrorException;
import com.boot.booking.restaurantapi.exceptions.NotFoundException;
import com.boot.booking.restaurantapi.repositories.ReservationRepository;
import com.boot.booking.restaurantapi.services.CancelReservationService;

public class CancelReservationServiceImpl implements CancelReservationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CancelReservationServiceImpl.class);

	@Autowired
	private ReservationRepository reservationRepository;

	public String deleteReservation(String locator) throws BookingExceptions {

		reservationRepository.findByLocator(locator)
				.orElseThrow(() -> new NotFoundException("LOCATOR_NOT_FOUND", "LOCATOR_NOT_FOUND"));
		try {
			reservationRepository.deleteByLocator(locator);
		} catch (Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}

		return "LOCATOR_DELETED";
	}

}
