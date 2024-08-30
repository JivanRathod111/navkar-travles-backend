package com.sites.navkar.service;

import java.util.Date;
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
import com.sites.navkar.repository.UserRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sites.navkar.entity.Booking;
import com.sites.navkar.repository.BookingRepository;

import java.util.List;

@Service
public class BookingService {

	 @Autowired
	    private BookingRepository bookingRepository;

	    @Autowired
	    private BusRepository busRepository;

	    @Autowired
	    private SeatRepository seatRepository;

	    public Booking createBooking(Booking bookingRequest) {
	        // Find the Bus entity by ID
	        Bus bus = busRepository.findById(bookingRequest.getBus().getId())
	                .orElseThrow(() -> new RuntimeException("Bus not found"));

	        // Set the Bus entity on the Booking
	        bookingRequest.setBus(bus);

	        // Set the Bus entity on each Seat and associate with the Booking
	        List<Seat> seats = bookingRequest.getSeats();
	        for (Seat seat : seats) {
	            seat.setBus(bus);  // Set Bus to Seat
	            seat.setBooking(bookingRequest); // Set Booking to Seat
	        }
	        bookingRequest.setSeats(seats);

	        // Save and return the Booking
	        return bookingRepository.save(bookingRequest);
	    }
	    
	    

//	public Booking saveBooking(Booking booking) {
//		return bookingRepository.save(booking);
//	}
	

	

	public Booking updateBooking(Long id, Booking updatedBooking) {
		Booking existingBooking = bookingRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));

		if (updatedBooking.getBookingDate() != null) {
			existingBooking.setBookingDate(updatedBooking.getBookingDate());
		}
		if (updatedBooking.getStatus() != null) {
			existingBooking.setStatus(updatedBooking.getStatus());
		}
		if (updatedBooking.getPaymentStatus() != null) {
			existingBooking.setPaymentStatus(updatedBooking.getPaymentStatus());
		}
		if (updatedBooking.getFare() != null) {
			existingBooking.setFare(updatedBooking.getFare());
		}
		if (updatedBooking.getUser() != null) {
			existingBooking.setUser(updatedBooking.getUser());
		}
		if (updatedBooking.getBus() != null) {
			existingBooking.setBus(updatedBooking.getBus());
		}
		if (updatedBooking.getSeats() != null && !updatedBooking.getSeats().isEmpty()) {
			List<Seat> updatedSeats = updatedBooking.getSeats();

			// Update the seat status
			for (Seat seat : updatedSeats) {
				seat.setIsBooked(true); // or whatever status indicates booked
				seatRepository.save(seat);
			}

			existingBooking.setSeats(updatedSeats);
		}

		return bookingRepository.save(existingBooking);
	}
   
	// Get All Bookings
	public List<Booking> getAllBooking() {
		return bookingRepository.findAll();
	}
    // Get Booking By Id
	public Booking getBookingById(Long id) {
		return bookingRepository.findById(id).orElse(null);
	}
    // Delete Booking
	public String deleteBooking(Long id) {
		if (bookingRepository.existsById(id)) {
			bookingRepository.deleteById(id);
			return "Booking deleted successfully";
		} else {
			return "Booking not found";
		}
	}
}
