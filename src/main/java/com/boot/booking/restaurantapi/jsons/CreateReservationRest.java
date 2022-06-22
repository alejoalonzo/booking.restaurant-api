package com.boot.booking.restaurantapi.jsons;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateReservationRest {
	
	
	@JsonProperty("date")
	private Date date;
	
	@JsonProperty("turnId")
	private Long turnId;
	
	@JsonProperty("person")
	private Long person;
	
	@JsonProperty("restaurantId")
	private Long restaurantId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("email")
	private String email;

	public final Date getDate() {
		return date;
	}

	public final void setDate(Date date) {
		this.date = date;
	}

	public final Long getTurnId() {
		return turnId;
	}

	public final void setTurnId(Long turnId) {
		this.turnId = turnId;
	}

	public final Long getPerson() {
		return person;
	}

	public final void setPerson(Long person) {
		this.person = person;
	}

	public final Long getRestaurantId() {
		return restaurantId;
	}

	public final void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

}
