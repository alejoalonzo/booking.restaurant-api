package com.boot.booking.restaurantapi.services;

import java.util.List;

import com.boot.booking.restaurantapi.exceptions.BookingExceptions;
import com.boot.booking.restaurantapi.jsons.RestaurantRest;

public interface RestaurantServices {
	RestaurantRest getRestaurantById(Long restaurantId) throws BookingExceptions;
	public List<RestaurantRest> getRestaurants() throws BookingExceptions;
}
