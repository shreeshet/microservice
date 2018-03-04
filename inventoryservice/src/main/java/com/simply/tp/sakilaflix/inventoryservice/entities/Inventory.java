package com.simply.tp.sakilaflix.inventoryservice.entities;

import com.vividsolutions.jts.geom.Point;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the inventory database table.
 * 
 */
@Entity
@Table(name="inventory")

//select invtry.inventory_id,invtry.film_id,invtry.store_id,
//		str.store_id,addr.address_id,addr.phone,addr.location
//		from inventory invtry
//		left outer join store str on str.store_id = invtry.store_id
//		left outer join address addr on str.address_id = addr.address_id
//		where invtry.film_id=2;

@NamedQuery(name="Inventory.findAll", query="SELECT i FROM Inventory i")
@SqlResultSetMapping(name="InventoryResults",
		classes = {
				@ConstructorResult(
						targetClass = com.simply.tp.sakilaflix.inventoryservice.dto.InventoryDetails.class,
						columns = {
								@ColumnResult(name = "film_id",type = int.class),
                                @ColumnResult(name = "rental_duration",type = byte.class),
                                @ColumnResult(name = "inventory_id", type = int.class),
                                @ColumnResult(name = "store_id", type = byte.class),
                                @ColumnResult(name = "last_update", type = Timestamp.class),
                                @ColumnResult(name = "location", type = Point.class)

						}
				)
		}
)

public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;
	private int inventoryId;
	private Timestamp lastUpdate;
	private Film film;
	private Store store;
	private Set<Rental> rentals;

	public Inventory() {
	}


	@Id
	@Column(name="inventory_id", unique=true, nullable=false)
	public int getInventoryId() {
		return this.inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}


	@Column(name="last_update", nullable=false)
	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}


	//bi-directional many-to-one association to Film
	@ManyToOne
	@JoinColumn(name="film_id", nullable=false)
	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}


	//bi-directional many-to-one association to Store
	@ManyToOne
	@JoinColumn(name="store_id", nullable=false)
	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}


	//bi-directional many-to-one association to Rental
	@OneToMany(mappedBy="inventory")
	public Set<Rental> getRentals() {
		return this.rentals;
	}

	public void setRentals(Set<Rental> rentals) {
		this.rentals = rentals;
	}

	public Rental addRental(Rental rental) {
		getRentals().add(rental);
		rental.setInventory(this);

		return rental;
	}

	public Rental removeRental(Rental rental) {
		getRentals().remove(rental);
		rental.setInventory(null);

		return rental;
	}

}