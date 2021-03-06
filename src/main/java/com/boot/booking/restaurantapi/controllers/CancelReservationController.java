package com.boot.booking.restaurantapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.boot.booking.restaurantapi.exceptions.BookingExceptions;
import com.boot.booking.restaurantapi.responses.BookingResponse;
import com.boot.booking.restaurantapi.services.CancelReservationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class CancelReservationController {

	@Autowired
	CancelReservationService cancelReservationService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/deleteReservation", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)

	public BookingResponse<String> deleteReservation(@RequestParam String locator) throws BookingExceptions {
		return new BookingResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
				cancelReservationService.deleteReservation(locator));
	}
}
