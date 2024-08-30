package com.sites.navkar.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
public class Trip {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    private String startPoint;
	    private String endPoint;
	    private LocalDate tripDate;
	    private LocalDateTime departureTime;
	    private LocalDateTime arrivalTime;
	    private Double availableSeats;

	    @ManyToOne
	    @JsonBackReference("bus-trips")
	    @JoinColumn(name = "bus_id", nullable = false)
	    private Bus bus;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getStartPoint() {
			return startPoint;
		}

		public void setStartPoint(String startPoint) {
			this.startPoint = startPoint;
		}

		public String getEndPoint() {
			return endPoint;
		}

		public void setEndPoint(String endPoint) {
			this.endPoint = endPoint;
		}

		public LocalDate getTripDate() {
			return tripDate;
		}

		public void setTripDate(LocalDate tripDate) {
			this.tripDate = tripDate;
		}

		public LocalDateTime getDepartureTime() {
			return departureTime;
		}

		public void setDepartureTime(LocalDateTime departureTime) {
			this.departureTime = departureTime;
		}

		public LocalDateTime getArrivalTime() {
			return arrivalTime;
		}

		public void setArrivalTime(LocalDateTime arrivalTime) {
			this.arrivalTime = arrivalTime;
		}

		public Double getAvailableSeats() {
			return availableSeats;
		}

		public void setAvailableSeats(Double availableSeats) {
			this.availableSeats = availableSeats;
		}

		public Bus getBus() {
			return bus;
		}

		public void setBus(Bus bus) {
			this.bus = bus;
		}
	    
	    

}