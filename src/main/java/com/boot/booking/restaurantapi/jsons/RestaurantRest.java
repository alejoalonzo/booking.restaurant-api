package com.boot.booking.restaurantapi.jsons;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestaurantRest {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("address")
	private String address;

	@JsonProperty("description")
	private String description;

	@JsonProperty("image")
	private String image;

	@JsonProperty("turns")
	private List<TurnRest> turns;

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getAddress() {
		return address;
	}

	public final void setAddress(String address) {
		this.address = address;
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(String description) {
		this.description = description;
	}

	public final String getImage() {
		return image;
	}

	public final void setImage(String image) {
		this.image = image;
	}

	public final List<TurnRest> getTurns() {
		return turns;
	}

	public final void setTurns(List<TurnRest> turns) {
		this.turns = turns;
	}
}
