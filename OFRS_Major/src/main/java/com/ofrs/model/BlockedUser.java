package com.ofrs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "blockedUser")
public class BlockedUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "userId")
	private RegisterUser user;

	public BlockedUser(int id, RegisterUser user) {
		super();
		this.id = id;
		this.user = user;
	}

	public BlockedUser(RegisterUser user) {
		super();
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RegisterUser getUser() {
		return user;
	}

	public void setUser(RegisterUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "BlockedUser [id=" + id + ", user=" + user + "]";
	}
	
	

}
