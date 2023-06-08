package com.test.services;

import java.util.List;

import com.test.entity.Hotel;

public interface HotelService {
	Hotel saveHotel(Hotel hotel);

	Hotel getSingleHotel(String id);

	List<Hotel> getAllHotel();
}
