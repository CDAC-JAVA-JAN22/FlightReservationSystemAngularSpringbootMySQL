package com.ofrs.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "register_user")
@JsonIgnoreProperties
//@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer"},allowSetters = true)
public class RegisterUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@NotNull
	@NotEmpty
	@Size(min=2, message="Name should have atleast two characters")
	private String userName;
	
	@Email
	private String userEmail;
	
	private String imagePath;
	
	private String role;
	
	private int attempts;
	
	private String verificationCode;
	

	public String getVerificationCode() {
		return verificationCode;
	}



	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}


	private boolean isEnabled;

	

	public boolean isEnabled() {
		return isEnabled;
	}



	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}


	@NotEmpty
	@NotNull
	@Size(min=10, message="Number should have atleast ten digits")
	private String contactNumber;
	
	@NotNull
	@Size(min=8, message="Passport should have atleast eight characters")
	private String password;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Feedback> feedback;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Complain> complain;
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private BlockedUser blockedUser;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<BookTicket> ticket;
	
	
	public RegisterUser() {}



	public RegisterUser(int userId,
			@NotNull @NotEmpty @Size(min = 2, message = "Name should have atleast two characters") String userName,
			@Email String userEmail, String imagePath, String role, int attempts, String verificationCode,
			boolean isEnabled,
			@NotEmpty @NotNull @Size(min = 10, message = "Number should have atleast ten digits") String contactNumber,
			@NotNull @Size(min = 8, message = "Passport should have atleast eight characters") String password,
			List<Feedback> feedback, List<Complain> complain, BlockedUser blockedUser, List<BookTicket> ticket) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.imagePath = imagePath;
		this.role = role;
		this.attempts = attempts;
		this.verificationCode = verificationCode;
		this.isEnabled = isEnabled;
		this.contactNumber = contactNumber;
		this.password = password;
		this.feedback = feedback;
		this.complain = complain;
		this.blockedUser = blockedUser;
		this.ticket = ticket;
	}



	public List<BookTicket> getTicket() {
		return ticket;
	}



	public void setTicket(List<BookTicket> ticket) {
		this.ticket = ticket;
	}



	public List<Feedback> getFeedback() {
		return feedback;
	}



	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}



	public List<Complain> getComplain() {
		return complain;
	}



	public void setComplain(List<Complain> complain) {
		this.complain = complain;
	}



	public BlockedUser getBlockedUser() {
		return blockedUser;
	}



	public void setBlockedUser(BlockedUser blockedUser) {
		this.blockedUser = blockedUser;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserEmail() {
		return userEmail;
	}



	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}



	public String getImagePath() {
		return imagePath;
	}



	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}



	public String getContactNumber() {
		return contactNumber;
	}



	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	public int getAttempts() {
		return attempts;
	}



	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}



	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	@Override
	public String toString() {
		return "RegisterUser [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", imagePath="
				+ imagePath + ", role=" + role + ", attempts=" + attempts + ", verificationCode=" + verificationCode
				+ ", isEnabled=" + isEnabled + ", contactNumber=" + contactNumber + ", password=" + password
				+ ", feedback=" + feedback + ", complain=" + complain + ", blockedUser=" + blockedUser + ", ticket="
				+ ticket + "]";
	}	
}