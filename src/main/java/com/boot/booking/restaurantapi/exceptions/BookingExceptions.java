package com.boot.booking.restaurantapi.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.boot.booking.restaurantapi.dtos.ErrorDto;

public class BookingExceptions extends Exception{
	
	private static final long serialVersionUID =1L;
	private final String code ;
	private final int responseCode;
	private final List<ErrorDto> errorList = new ArrayList<>();
	
	
	public BookingExceptions(String code, int responseCode, String message) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
	}
	public BookingExceptions(String code, int responseCode, String message, List<ErrorDto> errorLis) {
		super(message);
		this.code = code;
		this.errorList.addAll(errorList);
		this.responseCode = responseCode;
	}
	public final String getCode() {
		return code;
	}
	public final int getResponseCode() {
		return responseCode;
	}
	public final List<ErrorDto> getErrorList() {
		return errorList;
	}
	
}
