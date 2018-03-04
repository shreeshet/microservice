package com.simply.tp.sakilaflix.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the nicer_but_slower_film_list database table.
 * 
 */
@Entity
@Table(name="nicer_but_slower_film_list")
@NamedQuery(name="NicerButSlowerFilmList.findAll", query="SELECT n FROM NicerButSlowerFilmList n")
public class NicerButSlowerFilmList implements Serializable {
	private static final long serialVersionUID = 1L;
	private String actors;
	private String category;
	private String description;
	private int fid;
	private int length;
	private BigDecimal price;
	private String rating;
	private String title;

	public NicerButSlowerFilmList() {
	}


	@Lob
	public String getActors() {
		return this.actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}


	@Column(nullable=false, length=25)
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	@Lob
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Id
	@Column(name="FID")
	public int getFid() {
		return this.fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}


	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}


	@Column(precision=10, scale=2)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	@Column(length=1)
	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}


	@Column(length=255)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}