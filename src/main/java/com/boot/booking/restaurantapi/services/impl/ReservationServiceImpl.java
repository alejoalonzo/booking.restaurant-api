package com.boot.booking.restaurantapi.services.impl;


import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.booking.restaurantapi.entities.Reservation;
import com.boot.booking.restaurantapi.entities.Restaurant;
import com.boot.booking.restaurantapi.entities.Turn;
import com.boot.booking.restaurantapi.exceptions.BookingExceptions;
import com.boot.booking.restaurantapi.exceptions.InternalServerErrorException;
import com.boot.booking.restaurantapi.exceptions.NotFoundException;
import com.boot.booking.restaurantapi.jsons.CreateReservationRest;
import com.boot.booking.restaurantapi.jsons.ReservationRest;
import com.boot.booking.restaurantapi.repositories.ReservationRepository;
import com.boot.booking.restaurantapi.repositories.RestaurantRepository;
import com.boot.booking.restaurantapi.repositories.TurnRepository;
import com.boot.booking.restaurantapi.services.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);
	
	@Autowired
	private ReservationRepository reservationRespository;
	
	@Autowired
	private RestaurantRepository RestaurantRepository;
	
	@Autowired
	private TurnRepository turnRepository;

	public static final ModelMapper modelmapper = new ModelMapper();

	public ReservationRest getReservationById(Long reservationId) throws BookingExceptions {
		// TODO Auto-generated method stub
		return modelmapper.map(getReservationEntity(reservationId), ReservationRest.class);
	}

	private Reservation getReservationEntity(Long reservationId) throws BookingExceptions {
		return reservationRespository.findById(reservationId)
				.orElseThrow(() -> new NotFoundException("SNOT-401-1", "REERVATION_NOT_FOUND"));
	}

	public String createReservation(CreateReservationRest createReservationRest) throws BookingExceptions {
		final Restaurant restaurantId = RestaurantRepository.findById(createReservationRest.getRestaurantId())
				.orElseThrow(() -> new NotFoundException("RESTAURANT_NOT_FOUND", "RESTAURANT_NOT_FOUND"));
		
		final Turn turn = turnRepository.findById(createReservationRest.getTurnId())
				.orElseThrow(() -> new NotFoundException("TURN_NOT_FOUND", "TURN_NOT_FOUND"));
		
		String locator = generateLocator(restaurantId, createReservationRest);
		
		final Reservation reservation = new Reservation();
		
		reservation.setLocator(locator);
		reservation.setPerson(createReservationRest.getPerson());
		reservation.setDate(createReservationRest.getDate());
		reservation.setRestaurant(restaurantId);
		reservation.setTurn(turn.getName());
		
		try {
			reservationRespository.save(reservation);
		}catch(final Exception e){
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		
		return locator;
	}

	private String generateLocator(Restaurant restaurantId, CreateReservationRest createReservationRest)
			throws BookingExceptions {
		return restaurantId.getName() + createReservationRest.getTurnId();

	}
	
	public ReservationRest getReservation(Long reservationId)throws BookingExceptions{
		return null;
	}
}
