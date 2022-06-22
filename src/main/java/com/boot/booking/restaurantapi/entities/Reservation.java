package com.boot.booking.restaurantapi.entities;

import java.util.Date;

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
@Table (name="RESERVATION")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "TURN")
	private String  turn;
	
	@Column(name = "LOCATOR")
	private String  locator;
	
	@Column(name = "PERSON")
	private Long  person;
	
	@Column(name = "DATE")
	private Date date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RESTAURANT_ID", nullable = false)
	private Restaurant restaurant;

	@Column(name = "EMAIL")
	private String  email;
	
	@Column(name = "NAME")
	private String  name;
	
	@Column(name = "PAYMENT")
	private boolean  payment;
	
	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final String getLocator() {
		return locator;
	}

	public final void setLocator(String locator) {
		this.locator = locator;
	}

	public final Long getPerson() {
		return person;
	}

	public final void setPerson(Long person) {
		this.person = person;
	}

	public final Date getDate() {
		return date;
	}

	public final void setDate(Date date) {
		this.date = date;
	}

	public final Restaurant getRestaurant() {
		return restaurant;
	}

	public final void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public final String getTurn() {
		return turn;
	}

	public final void setTurn(String turn) {
		this.turn = turn;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final boolean isPayment() {
		return payment;
	}

	public final void setPayment(boolean payment) {
		this.payment = payment;
	}

}
