package com.boot.booking.restaurantapi.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="BOARD")
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "CAPACITY")
	private Long  capacity;
	
	@Column(name = "NUMBER")
	private Long  number;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "RESTAURANT_ID", nullable = false)
	private Restaurant restaurant;

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final Long getCapacity() {
		return capacity;
	}

	public final void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

	public final Long getNumber() {
		return number;
	}

	public final void setNumber(Long number) {
		this.number = number;
	}

	public final Restaurant getRestaurant() {
		return restaurant;
	}

	public final void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
