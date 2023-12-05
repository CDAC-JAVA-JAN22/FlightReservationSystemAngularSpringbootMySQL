package com.ofrs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bookTicket")
public class BookTicket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	
	@ManyToOne
	@JoinColumn(name = "flightId")
	private Flights flight;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private RegisterUser user;
	
	@OneToOne
	@JoinColumn(name = "offerId")
	private Offer offer; 
	
	private String passangerName;
	private String returnDate;
	private double totalAmount;
	
	public BookTicket() {
		// TODO Auto-generated constructor stub
	}

	public BookTicket(int bookingId, Flights flight, RegisterUser user, Offer offer, String passangerName,
			String returnDate, double totalAmount) {
		super();
		this.bookingId = bookingId;
		this.flight = flight;
		this.user = user;
		this.offer = offer;
		this.passangerName = passangerName;
		this.returnDate = returnDate;
		this.totalAmount = totalAmount;
	}
	
	

	public BookTicket(Flights flight, RegisterUser user, Offer offer, String passangerName, String returnDate,
			double totalAmount) {
		super();
		this.flight = flight;
		this.user = user;
		this.offer = offer;
		this.passangerName = passangerName;
		this.returnDate = returnDate;
		this.totalAmount = totalAmount;
	}
	
	

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Flights getFlight() {
		return flight;
	}

	public void setFlight(Flights flight) {
		this.flight = flight;
	}

	public RegisterUser getUser() {
		return user;
	}

	public void setUser(RegisterUser user) {
		this.user = user;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public String getPassangerName() {
		return passangerName;
	}

	public void setPassangerName(String passangerName) {
		this.passangerName = passangerName;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	
	

}
