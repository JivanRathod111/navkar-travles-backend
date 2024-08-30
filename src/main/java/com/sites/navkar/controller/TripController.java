package com.sites.navkar.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.sites.navkar.entity.Bus;
import com.sites.navkar.entity.Trip;
import com.sites.navkar.service.BusService;
import com.sites.navkar.service.TripService;

@RestController
@RequestMapping("/trip")
public class TripController {
	
	@Autowired
	TripService tripService;
	
	@PostMapping("/")
	public Trip createTripDetails(@RequestBody Trip trip) {
		return tripService.createTripDetails(trip);
	}
	@GetMapping("/{id}")
	public Trip findTripByID(@PathVariable Long id) {
		return tripService.getTripDetail(id);
	}
	
	@GetMapping("/")
	public List<Trip> findAllTrip() {
		return tripService.getAllTrip();
	}
	
	@DeleteMapping("/{id}")
	public String deleteTrip(@PathVariable Long id) {
		return tripService.deleteTrip(id);
	}
	
	 @PutMapping("/{id}")
	    public ResponseEntity<Trip> updateTrip(@PathVariable Long id, @RequestBody Trip tripDetails) {
	        Trip updatedTrip = tripService.updateTrip(id, tripDetails);
	        return ResponseEntity.ok(updatedTrip);
	    }


}
