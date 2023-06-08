package com.test.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.entity.Hotel;
import com.test.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	static List<Hotel> list = new ArrayList<>();

	@Autowired
	RestTemplate restTemplate;

	public HotelServiceImpl() {
		Hotel hotel = new Hotel("201", "Radisson Hotel", "Delhi", "7-star hotel");
		Hotel hotel1 = new Hotel("202", "Maurya Hotel", "Mumbai", "7-star hotel");
		Hotel hotel2 = new Hotel("203", "Blue Star Hotel", "Ranchi", "7-star hotel");
		list.add(hotel);
		list.add(hotel1);
		list.add(hotel2);
	}

	@Override
	public Hotel saveHotel(Hotel hotel) {
		String random = UUID.randomUUID().toString();
		hotel.setId(random);
		list.add(hotel);
		return hotel;
	}

	@Override
	public Hotel getSingleHotel(String id) {
		for (Hotel z : list) {
			if (z.getId().equals(id)) {
				return z;
			}
		}
		return null;
	}

	@Override
	public List<Hotel> getAllHotel() {
		return list;
	}

}
