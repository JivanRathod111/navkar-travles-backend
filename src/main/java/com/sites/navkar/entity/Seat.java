package com.sites.navkar.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Seat {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    private String seatNumber;
	    private Boolean isBooked;

	    @ManyToOne
	    @JoinColumn(name = "bus_id")
	    private Bus bus;

	    @ManyToOne
	    @JsonBackReference("booking-seats")
	    @JoinColumn(name = "booking_id")
	    private Booking booking;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getSeatNumber() {
			return seatNumber;
		}

		public void setSeatNumber(String seatNumber) {
			this.seatNumber = seatNumber;
		}

		public Boolean getIsBooked() {
			return isBooked;
		}

		public void setIsBooked(Boolean isBooked) {
			this.isBooked = isBooked;
		}

		public Bus getBus() {
			return bus;
		}

		public void setBus(Bus bus) {
			this.bus = bus;
		}

		public Booking getBooking() {
			return booking;
		}

		public void setBooking(Booking booking) {
			this.booking = booking;
		}
	    
	    
}
