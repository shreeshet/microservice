package com.simply.tp.sakilaflix.inventoryservice.dao;

import com.simply.tp.sakilaflix.inventoryservice.dto.InventoryDetails;
import com.simply.tp.sakilaflix.inventoryservice.entities.Address;
import com.simply.tp.sakilaflix.inventoryservice.entities.FilmList;

import java.util.List;

/**
 * Created by shreeharshashet on 2/7/18.
 */
public interface InventorySeviceDAO {
    public List<InventoryDetails> searchInventory(int filmId);
}
