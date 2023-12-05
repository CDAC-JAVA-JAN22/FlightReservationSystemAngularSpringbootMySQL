package com.ofrs.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "offer")
public class Offer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int offerId;
	
	private String offerName;
	private String offerCode;
	private double offerAmount;
	
	@OneToOne(mappedBy = "offer",cascade = CascadeType.ALL)
	private BookTicket ticket;
	
	public Offer(int offerId, String offerName, String offerCode, double offerAmount) {
		super();
		this.offerId = offerId;
		this.offerName = offerName;
		this.offerCode = offerCode;
		this.offerAmount = offerAmount;
	}

	public Offer(String offerName, String offerCode, double offerAmount) {
		super();
		this.offerName = offerName;
		this.offerCode = offerCode;
		this.offerAmount = offerAmount;
	}
	


	public Offer(String offerName, String offerCode, double offerAmount, BookTicket ticket) {
		super();
		this.offerName = offerName;
		this.offerCode = offerCode;
		this.offerAmount = offerAmount;
		this.ticket = ticket;
	}

	public BookTicket getTicket() {
		return ticket;
	}

	public void setTicket(BookTicket ticket) {
		this.ticket = ticket;
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public String getOfferCode() {
		return offerCode;
	}

	public void setOfferCode(String offerCode) {
		this.offerCode = offerCode;
	}

	public double getOfferAmount() {
		return offerAmount;
	}

	public void setOfferAmount(double offerAmount) {
		this.offerAmount = offerAmount;
	}

	@Override
	public String toString() {
		return "Offer [offerId=" + offerId + ", offerName=" + offerName + ", offerCode=" + offerCode + ", offerAmount="
				+ offerAmount + "]";
	}
	
	

}
