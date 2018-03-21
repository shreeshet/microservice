package com.simply.tp.sakilaflix.userservice.entities;

import com.vividsolutions.jts.geom.Point;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name="address")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	private int addressId;
	private String address;
	private String address2;
	private String district;
	private Timestamp lastUpdate;
	private Point location;
	private String phone;
	private String postalCode;
	private City city;
	private Set<Customer> customers;
	private Set<Staff> staffs;
	private Set<Store> stores;

	public Address() {
	}


	@Id
	@Column(name="address_id", unique=true, nullable=false)
	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	@Column(nullable=false, length=50)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@Column(length=50)
	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	@Column(nullable=false, length=20)
	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}


	@Column(name="last_update", nullable=false)
	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}


	@Column(nullable=false)
	public Point getLocation() {
		return this.location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}


	@Column(nullable=false, length=20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Column(name="postal_code", length=10)
	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="city_id", nullable=false)
	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}


	//bi-directional many-to-one association to CustomerDTO
	@OneToMany(mappedBy="address")
	public Set<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setAddress(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setAddress(null);

		return customer;
	}


	//bi-directional many-to-one association to Staff
	@OneToMany(mappedBy="address")
	public Set<Staff> getStaffs() {
		return this.staffs;
	}

	public void setStaffs(Set<Staff> staffs) {
		this.staffs = staffs;
	}

	public Staff addStaff(Staff staff) {
		getStaffs().add(staff);
		staff.setAddress(this);

		return staff;
	}

	public Staff removeStaff(Staff staff) {
		getStaffs().remove(staff);
		staff.setAddress(null);

		return staff;
	}


	//bi-directional many-to-one association to Store
	@OneToMany(mappedBy="address")
	public Set<Store> getStores() {
		return this.stores;
	}

	public void setStores(Set<Store> stores) {
		this.stores = stores;
	}

	public Store addStore(Store store) {
		getStores().add(store);
		store.setAddress(this);

		return store;
	}

	public Store removeStore(Store store) {
		getStores().remove(store);
		store.setAddress(null);

		return store;
	}

}