package com.sites.navkar.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sites.navkar.entity.Bus;
import com.sites.navkar.entity.Trip;
import com.sites.navkar.repository.TripRepository;

@Service
public class TripService {

	@Autowired
	TripRepository tripRepository;

	public Trip createTripDetails(Trip trip) {
		return tripRepository.save(trip);
	}

	public List<Trip> getAllTrip() {
		return tripRepository.findAll();
	}

	public Trip getTripDetail(Long id) {
		return tripRepository.findById(id).get();
	}

	public String deleteTrip(Long id) {
		tripRepository.deleteById(id);
		return "Trip Deleted Successfully";
	}

	public Trip updateTrip(Long id, Trip tripDetails) {
		Optional<Trip> optionalTrip = tripRepository.findById(id);

		if (optionalTrip.isPresent()) {
			Trip trip = optionalTrip.get();

			if (tripDetails.getStartPoint() != null) {
				trip.setStartPoint(tripDetails.getStartPoint());
			}
			if (tripDetails.getEndPoint() != null) {
				trip.setEndPoint(tripDetails.getEndPoint());
			}
			if (tripDetails.getTripDate() != null) {
				trip.setTripDate(tripDetails.getTripDate());
			}
			if (tripDetails.getDepartureTime() != null) {
				trip.setDepartureTime(tripDetails.getDepartureTime());
			}
			if (tripDetails.getArrivalTime() != null) {
				trip.setArrivalTime(tripDetails.getArrivalTime());
			}
			if (tripDetails.getAvailableSeats() != null) {
				trip.setAvailableSeats(tripDetails.getAvailableSeats());
			}
			if (tripDetails.getBus() != null) {
				trip.setBus(tripDetails.getBus());
			}

			return tripRepository.save(trip);
		} else {
			throw new RuntimeException("Trip not found with id " + id);
		}
	}

}
