package com.simply.tp.sakilaflix.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the language database table.
 * 
 */
@Entity
@Table(name="language")
@NamedQuery(name="Language.findAll", query="SELECT l FROM Language l")
public class Language implements Serializable {
	private static final long serialVersionUID = 1L;
	private byte languageId;
	private Timestamp lastUpdate;
	private String name;
	private Set<Film> films1;
	private Set<Film> films2;

	public Language() {
	}


	@Id
	@Column(name="language_id", unique=true, nullable=false)
	public byte getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(byte languageId) {
		this.languageId = languageId;
	}


	@Column(name="last_update", nullable=false)
	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}


	@Column(nullable=false, length=20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//bi-directional many-to-one association to Film
	@OneToMany(mappedBy="language1")
	public Set<Film> getFilms1() {
		return this.films1;
	}

	public void setFilms1(Set<Film> films1) {
		this.films1 = films1;
	}

	public Film addFilms1(Film films1) {
		getFilms1().add(films1);
		films1.setLanguage1(this);

		return films1;
	}

	public Film removeFilms1(Film films1) {
		getFilms1().remove(films1);
		films1.setLanguage1(null);

		return films1;
	}


	//bi-directional many-to-one association to Film
	@OneToMany(mappedBy="language2")
	public Set<Film> getFilms2() {
		return this.films2;
	}

	public void setFilms2(Set<Film> films2) {
		this.films2 = films2;
	}

	public Film addFilms2(Film films2) {
		getFilms2().add(films2);
		films2.setLanguage2(this);

		return films2;
	}

	public Film removeFilms2(Film films2) {
		getFilms2().remove(films2);
		films2.setLanguage2(null);

		return films2;
	}

}