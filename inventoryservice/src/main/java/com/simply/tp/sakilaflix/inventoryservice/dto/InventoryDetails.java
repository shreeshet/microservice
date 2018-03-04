package com.simply.tp.sakilaflix.inventoryservice.dto;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by shreeharshashet on 2/24/18.
 */
public class InventoryDetails {
    private int filmId;
    private byte rentalDuration;
    private int inventoryId;
    private byte storeId;
    private Timestamp lastUpdate;
    private Geometry location;

    public InventoryDetails() {
    }

    public InventoryDetails(int filmId, byte rentalDuration, int inventoryId, byte storeId, Date lastUpdate,Geometry location) {
        this.filmId = filmId;
        this.rentalDuration = rentalDuration;
        this.inventoryId = inventoryId;
        this.storeId = storeId;
        this.lastUpdate = new Timestamp(lastUpdate.getTime());
        this.location = location;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public byte getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(byte rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public byte getStoreId() {
        return storeId;
    }

    public void setStoreId(byte storeId) {
        this.storeId = storeId;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Geometry getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
