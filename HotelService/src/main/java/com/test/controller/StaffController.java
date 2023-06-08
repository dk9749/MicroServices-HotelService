package com.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staffs")
public class StaffController {

	@GetMapping
	public ResponseEntity<Map<String, String>> getAllStaffs() {
		Map<String, String> map = new HashMap<>();
		map.put("StaffName", "Gajodhar");
		map.put("StaffAddress", "Gonda, UP");
		return ResponseEntity.status(HttpStatus.OK).body(map);
	}

}
