package com.sites.navkar.service;

import java.sql.Date;

public class BookingRequest {
	 private Long userId;
	    private Long busId;
	    private Long seatId;
	    private Date bookingDate;
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public Long getBusId() {
			return busId;
		}
		public void setBusId(Long busId) {
			this.busId = busId;
		}
		public Long getSeatId() {
			return seatId;
		}
		public void setSeatId(Long seatId) {
			this.seatId = seatId;
		}
		public Date getBookingDate() {
			return bookingDate;
		}
		public void setBookingDate(Date bookingDate) {
			this.bookingDate = bookingDate;
		}
	    
}
