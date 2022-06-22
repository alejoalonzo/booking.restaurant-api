package com.boot.booking.restaurantapi.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="RESTAURANT")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "NAME")
	private String  name;
	
	@Column(name = "ADDRESS")
	private String  address;
	
	@Column(name = "DESCRIPTION")
	private String  description;
	
	@Column(name = "IMAGE")
	private String  image;
	
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY, mappedBy="restaurant")
	private List<Reservation> reseravtions;
	
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY, mappedBy="restaurant")
	private List<Board> boards;
	
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY, mappedBy="restaurant")
	private List<Turn> turns;

	@Column(name = "PRICE")
	private Long price;
	
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

	public final List<Reservation> getReseravtions() {
		return reseravtions;
	}

	public final void setReseravtions(List<Reservation> reseravtions) {
		this.reseravtions = reseravtions;
	}

	public final List<Board> getBoards() {
		return boards;
	}

	public final void setBoards(List<Board> boards) {
		this.boards = boards;
	}

	public final List<Turn> getTurns() {
		return turns;
	}

	public final void setTurns(List<Turn> turns) {
		this.turns = turns;
	}

	public final Long getPrice() {
		return price;
	}

	public final void setPrice(Long price) {
		this.price = price;
	}
}

