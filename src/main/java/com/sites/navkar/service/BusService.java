package com.sites.navkar.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sites.navkar.entity.Bus;
import com.sites.navkar.entity.Seat;
import com.sites.navkar.repository.BusRepository;
import com.sites.navkar.repository.TripRepository;

@Service
public class BusService {

	@Autowired
	private BusRepository busRepository;

	public Bus saveBus(Bus bus) {
		return busRepository.save(bus);
	}

	public List<Bus> searchBuses(String startPoint, String endPoint, LocalDate date) {
		return busRepository.findByStartPointAndEndPointAndDate(startPoint, endPoint, date);
	}

	public List<Bus> getAllBus() {
		return busRepository.findAll();
	}

	public Bus getBusDetail(Long id) {
		return busRepository.findById(id).get();
	}

	public String deleteBus(Long id) {
		busRepository.deleteById(id);
		return "Bus Deleted Successfully";
	}

	public Bus updateBus(Bus correctBus, Long id) {
		// Fetch the user by ID, if not found, return null
		Bus bus = busRepository.findById(id).orElse(null);

		if (bus == null) {
			return null;
		}

		// Save the updated user back to the repository
		return busRepository.save(bus);
	}

}
