package com.sites.navkar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sites.navkar.entity.Booking;
import com.sites.navkar.entity.Bus;
import com.sites.navkar.entity.Seat;
import com.sites.navkar.entity.User;
import com.sites.navkar.repository.SeatRepository;
import com.sites.navkar.service.BusService;
import com.sites.navkar.service.SeatService;

@RestController
@RequestMapping("/seat")
public class SeatController {
	@Autowired
	private SeatService seatService;

	@Autowired
	private BusService busService;

	@PutMapping("/update/{id}")
	public ResponseEntity<Seat> updateSeat(@PathVariable Long id, @RequestBody Seat updatedSeat) {

		Optional<Seat> updatedSeatOptional = seatService.updateSeat(id, updatedSeat);

		if (updatedSeatOptional.isPresent()) {
			return ResponseEntity.ok(updatedSeatOptional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Seat>> findAllSeat() {
		try {
			List<Seat> seats = seatService.getAllSeats();
			return new ResponseEntity<>(seats, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/bus/{busId}")
    public List<Seat> getSeatsByBusId(@PathVariable Long busId) {
        return seatService.getSeatsByBusId(busId);
    }
}
