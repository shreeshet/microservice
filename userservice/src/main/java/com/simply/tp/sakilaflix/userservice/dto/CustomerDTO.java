package com.simply.tp.sakilaflix.userservice.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class CustomerDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int customerId;
	private byte active;
	private Date createDate;
	private String email;
	private String firstName;
	private String lastName;
	private Timestamp lastUpdate;


	public CustomerDTO(int customerId, byte active, Date createDate, String email, String firstName, String lastName) {
		this.customerId = customerId;
		this.active = active;
		this.createDate = createDate;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public CustomerDTO() {}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public byte getActive() {
		return active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}