package com.sites.navkar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sites.navkar.entity.Booking;
import com.sites.navkar.entity.Bus;
import com.sites.navkar.entity.Seat;
import com.sites.navkar.entity.User;
import com.sites.navkar.repository.BookingRepository;
import com.sites.navkar.repository.BusRepository;
import com.sites.navkar.repository.SeatRepository;

@Service
public class SeatService {

	@Autowired
	private SeatRepository seatRepository;

	@Autowired
	private BusRepository busRepository;

	public Optional<Seat> updateSeat(Long id, Seat updatedSeat) {
        return seatRepository.findById(id).map(seat -> {
            if (updatedSeat.getSeatNumber() != null) {
                seat.setSeatNumber(updatedSeat.getSeatNumber());
            }
            if (updatedSeat.getIsBooked() != null) {
                seat.setIsBooked(updatedSeat.getIsBooked());
            }
            if (updatedSeat.getBus() != null) {
                seat.setBus(updatedSeat.getBus()); // Update bus details
            }
            return seatRepository.save(seat);
        });
    }
	
	public List<Seat> getSeatsByBusId(Long busId) {
        return seatRepository.findByBusId(busId);
    }

	public List<Seat> getAllSeats() {
		return seatRepository.findAll();
	}

}
