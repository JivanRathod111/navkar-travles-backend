package com.sites.navkar.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sites.navkar.entity.Booking;
import com.sites.navkar.entity.Bus;
import com.sites.navkar.entity.Seat;
import com.sites.navkar.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

//    @PostMapping("/")
//	public Booking createBooking(@RequestBody Booking booking) {
//		return bookingService.saveBooking(booking);
//	}
    
    @PostMapping("/")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking bookingRequest) {
        Booking createdBooking = bookingService.createBooking(bookingRequest);
        return ResponseEntity.ok(createdBooking);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        Booking updatedBooking = bookingService.updateBooking(id, booking);
        return ResponseEntity.ok(updatedBooking);
    }

    @GetMapping("/")
	public List<Booking> findAllBooking() {
		return bookingService.getAllBooking();
	}

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        try {
            Booking booking = bookingService.getBookingById(id);
            if (booking != null) {
                return new ResponseEntity<>(booking, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        try {
            String response = bookingService.deleteBooking(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting booking", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
