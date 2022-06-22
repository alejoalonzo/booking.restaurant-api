package com.boot.booking.restaurantapi.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.boot.booking.restaurantapi.controllers.RestaurantController;
import com.boot.booking.restaurantapi.exceptions.BookingExceptions;
import com.boot.booking.restaurantapi.jsons.RestaurantRest;
import com.boot.booking.restaurantapi.jsons.TurnRest;
import com.boot.booking.restaurantapi.responses.BookingResponse;
import com.boot.booking.restaurantapi.services.RestaurantServices;

public class RestaurantControllerTest {

	private static final Long RESTAURANT_ID = 1L;
	private static final String NAME = "Burger";
	private static final String DESCRIPTION = "All kind of buergers";
	private static final String ADDRES = "659 N San Fernando, Lo Angeles";
	private static final String IMAGE = "https://image.com";

	private static final String SUCCESS_STAUS = "Success";
	private static final String SUCCESS_CODE = "200 OK";
	private static final String OK = "OK";

	public static final List<TurnRest> TURN_LIST = new ArrayList<>();
	public static final RestaurantRest RESTAURANT_REST = new RestaurantRest();

	@Mock
	RestaurantServices restaurantServices;

	@InjectMocks
	RestaurantController restaurantController;

	@SuppressWarnings("deprecation")
	@Before()
	public void init() throws BookingExceptions {
		MockitoAnnotations.initMocks(this);

		RESTAURANT_REST.setName(NAME);
		RESTAURANT_REST.setDescription(DESCRIPTION);
		RESTAURANT_REST.setAddress(ADDRES);
		RESTAURANT_REST.setId(RESTAURANT_ID);
		RESTAURANT_REST.setImage(IMAGE);
		RESTAURANT_REST.setTurns(TURN_LIST);

		Mockito.when(restaurantServices.getRestaurantById(RESTAURANT_ID)).thenReturn(RESTAURANT_REST);

	}

	@Test
	public void getRestaurantByIdTest() throws BookingExceptions {
		final BookingResponse<RestaurantRest> response = restaurantController.getRestaurantById(RESTAURANT_ID);

		assertEquals(response.getStatus(), SUCCESS_STAUS);
		assertEquals(response.getCode(), SUCCESS_CODE);
		assertEquals(response.getMessage(), OK);
		assertEquals(response.getData(), RESTAURANT_REST);
	}
}
