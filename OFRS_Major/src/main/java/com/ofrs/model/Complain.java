package com.ofrs.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "complain")
public class Complain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int complainId;
	private String complainDetails;
	private String complainStatus;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private RegisterUser user;
	

	public Complain() {
		// TODO Auto-generated constructor stub
	}


	public Complain(int complainId, String complainDetails, String complainStatus, RegisterUser user) {
		super();
		this.complainId = complainId;
		this.complainDetails = complainDetails;
		this.complainStatus = complainStatus;
		this.user = user;
	}



	public Complain(String complainDetails, String complainStatus, RegisterUser user) {
		super();
		this.complainDetails = complainDetails;
		this.complainStatus = complainStatus;
		this.user = user;
	}



	public RegisterUser getUser() {
		return user;
	}


	public void setUser(RegisterUser user) {
		this.user = user;
	}

	public int getComplainId() {
		return complainId;
	}


	public void setComplainId(int complainId) {
		this.complainId = complainId;
	}




	public String getComplainDetails() {
		return complainDetails;
	}


	public void setComplainDetails(String complainDetails) {
		this.complainDetails = complainDetails;
	}


	public String getComplainStatus() {
		return complainStatus;
	}


	public void setComplainStatus(String complainStatus) {
		this.complainStatus = complainStatus;
	}




	@Override
	public String toString() {
		return "Complain [complainId=" + complainId + ", complainDetails=" + complainDetails + ", complainStatus="
				+ complainStatus + ", user=" + user + "]";
	}


	
	

}
