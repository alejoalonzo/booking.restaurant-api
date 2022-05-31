package com.boot.booking.restaurantapi.dtos;

import java.io.Serializable;

public class ErrorDto implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	private String name;
	private String value;
	
	public ErrorDto(String name, String value) {
		this.name = name;
		this.value = value;
	} 
	
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getValue() {
		return value;
	}
	public final void setValue(String value) {
		this.value = value;
	}
	
}
