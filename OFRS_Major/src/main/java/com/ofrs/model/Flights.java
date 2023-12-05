package com.ofrs.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "flights")
public class Flights {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long flightId;
	

	private String flightName;
	private String source;
	private String destination;
	private String departureDate;
	private String departureTime;
	private String stops;
	private int totalSeats;
	private double basePrice;
	
	@OneToMany(mappedBy = "flight",cascade = CascadeType.ALL)
	private List<BookTicket> ticket;
	
	
	public Flights(String flightName, String source, String destination, String departureDate, String departureTime,
			String stops, int totalSeats, double basePrice) {
		super();
		this.flightName = flightName;
		this.source = source;
		this.destination = destination;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.stops = stops;
		this.totalSeats = totalSeats;
		this.basePrice = basePrice;
	}



	public Flights(long flightId, String flightName, String source, String destination, String departureDate,
			String departureTime, String stops, int totalSeats, double basePrice) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.source = source;
		this.destination = destination;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.stops = stops;
		this.totalSeats = totalSeats;
		this.basePrice = basePrice;
	}



	public Flights(long flightId, String flightName, String source, String destination, String departureDate,
			String departureTime, String stops, int totalSeats, double basePrice, List<BookTicket> ticket) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.source = source;
		this.destination = destination;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.stops = stops;
		this.totalSeats = totalSeats;
		this.basePrice = basePrice;
		this.ticket = ticket;
	}
	
	

	public List<BookTicket> getTicket() {
		return ticket;
	}


	public void setTicket(List<BookTicket> ticket) {
		this.ticket = ticket;
	}



	public long getFlightId() {
		return flightId;
	}



	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}



	public String getFlightName() {
		return flightName;
	}



	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}



	public String getSource() {
		return source;
	}



	public void setSource(String source) {
		this.source = source;
	}



	public String getDestination() {
		return destination;
	}



	public void setDestination(String destination) {
		this.destination = destination;
	}



	public String getDepartureDate() {
		return departureDate;
	}



	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}



	public String getDepartureTime() {
		return departureTime;
	}



	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}



	public String getStops() {
		return stops;
	}



	public void setStops(String stops) {
		this.stops = stops;
	}



	public int getTotalSeats() {
		return totalSeats;
	}



	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}



	public double getBasePrice() {
		return basePrice;
	}



	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}



	@Override
	public String toString() {
		return "Flights [flightId=" + flightId + ", flightName=" + flightName + ", source=" + source + ", destination="
				+ destination + ", departureDate=" + departureDate + ", departureTime=" + departureTime + ", stops="
				+ stops + ", totalSeats=" + totalSeats + ", basePrice=" + basePrice + "]";
	}
	
	
	
}
