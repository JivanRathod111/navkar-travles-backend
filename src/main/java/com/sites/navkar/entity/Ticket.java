package com.sites.navkar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Ticket {
	
	@Id
	Long id;
	Long seatNumber;
	String passengerName;
	Long age;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(Long seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	
//	@ManyToOne
//	Booking booking;
	

}
