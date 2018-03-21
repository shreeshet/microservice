package com.simply.tp.sakilaflix.userservice.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name="category")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	private byte categoryId;
	private Timestamp lastUpdate;
	private String name;
	private Set<FilmCategory> filmCategories;

	public Category() {
	}


	@Id
	@Column(name="category_id", unique=true, nullable=false)
	public byte getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(byte categoryId) {
		this.categoryId = categoryId;
	}


	@Column(name="last_update", nullable=false)
	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}


	@Column(nullable=false, length=25)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//bi-directional many-to-one association to FilmCategory
	@OneToMany(mappedBy="category")
	public Set<FilmCategory> getFilmCategories() {
		return this.filmCategories;
	}

	public void setFilmCategories(Set<FilmCategory> filmCategories) {
		this.filmCategories = filmCategories;
	}

	public FilmCategory addFilmCategory(FilmCategory filmCategory) {
		getFilmCategories().add(filmCategory);
		filmCategory.setCategory(this);

		return filmCategory;
	}

	public FilmCategory removeFilmCategory(FilmCategory filmCategory) {
		getFilmCategories().remove(filmCategory);
		filmCategory.setCategory(null);

		return filmCategory;
	}

}