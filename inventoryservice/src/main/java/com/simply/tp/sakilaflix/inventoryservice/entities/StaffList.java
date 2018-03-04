package com.simply.tp.sakilaflix.inventoryservice.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the staff_list database table.
 * 
 */
@Entity
@Table(name="staff_list")
@NamedQuery(name="StaffList.findAll", query="SELECT s FROM StaffList s")
public class StaffList implements Serializable {
	private static final long serialVersionUID = 1L;
	private String address;
	private String city;
	private String country;
	private byte id;
	private String name;
	private String phone;
	private byte sid;
	private String zip_code;

	public StaffList() {
	}


	@Column(nullable=false, length=50)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@Column(nullable=false, length=50)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	@Column(nullable=false, length=50)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	@Id
	@Column(name="ID", nullable=false)
	public byte getId() {
		return this.id;
	}

	public void setId(byte id) {
		this.id = id;
	}


	@Column(length=91)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(nullable=false, length=20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Column(name="SID", nullable=false)
	public byte getSid() {
		return this.sid;
	}

	public void setSid(byte sid) {
		this.sid = sid;
	}


	@Column(name="`zip code`", length=10)
	public String getZip_code() {
		return this.zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

}