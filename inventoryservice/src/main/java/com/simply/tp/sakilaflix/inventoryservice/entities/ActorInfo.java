package com.simply.tp.sakilaflix.inventoryservice.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the actor_info database table.
 * 
 */
@Entity
@Table(name="actor_info")
@NamedQuery(name="ActorInfo.findAll", query="SELECT a FROM ActorInfo a")
public class ActorInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int actorId;
	private String filmInfo;
	private String firstName;
	private String lastName;

	public ActorInfo() {
	}


	@Id
	@Column(name="actor_id", nullable=false)
	public int getActorId() {
		return this.actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}


	@Lob
	@Column(name="film_info")
	public String getFilmInfo() {
		return this.filmInfo;
	}

	public void setFilmInfo(String filmInfo) {
		this.filmInfo = filmInfo;
	}


	@Column(name="first_name", nullable=false, length=45)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	@Column(name="last_name", nullable=false, length=45)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}