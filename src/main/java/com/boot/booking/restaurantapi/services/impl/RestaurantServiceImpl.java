package com.boot.booking.restaurantapi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.booking.restaurantapi.entities.Restaurant;
import com.boot.booking.restaurantapi.exceptions.BookingExceptions;
import com.boot.booking.restaurantapi.exceptions.NotFoundException;
import com.boot.booking.restaurantapi.jsons.RestaurantRest;
import com.boot.booking.restaurantapi.repositories.RestaurantRepository;
import com.boot.booking.restaurantapi.services.RestaurantServices;

@Service
public class RestaurantServiceImpl implements RestaurantServices {

	@Autowired
	RestaurantRepository restaurantRespository;

	public static final ModelMapper modelmapper = new ModelMapper();

	public RestaurantRest getRestaurantById(Long restaurantId) throws BookingExceptions {
		// TODO Auto-generated method stub
		return modelmapper.map(getRestaurantEntity(restaurantId), RestaurantRest.class);
	}

	public List<RestaurantRest> getRestaurants() throws BookingExceptions {
		final List<Restaurant> restaurantsEntity = restaurantRespository.findAll();
		return restaurantsEntity.stream().map(service -> modelmapper.map(service, RestaurantRest.class))
				.collect(Collectors.toList());
	}

	private Restaurant getRestaurantEntity(Long restaurantId) throws BookingExceptions {
		return restaurantRespository.findById(restaurantId)
				.orElseThrow(() -> new NotFoundException("SNOT-401-1", "RESTAURANT_NOT_FOUND"));
	}

}
