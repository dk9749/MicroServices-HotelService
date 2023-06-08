package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Hotel;
import com.test.servicesImpl.HotelServiceImpl;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	@Autowired
	HotelServiceImpl hotelServiceImpl;

	@PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels() {
		List<Hotel> allHotel = hotelServiceImpl.getAllHotel();
		return ResponseEntity.status(HttpStatus.OK).body(allHotel);
	}

	@PreAuthorize("hasAuthority('SCOPE_internal')")
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getSingleHotel(@PathVariable String id) {
		Hotel singleHotel = hotelServiceImpl.getSingleHotel(id);
		return ResponseEntity.status(HttpStatus.OK).body(singleHotel);
	}

	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
		Hotel saveHotel = hotelServiceImpl.saveHotel(hotel);
		return ResponseEntity.status(HttpStatus.OK).body(saveHotel);
	}
}
