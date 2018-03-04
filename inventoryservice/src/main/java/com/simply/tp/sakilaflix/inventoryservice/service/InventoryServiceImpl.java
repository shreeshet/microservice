package com.simply.tp.sakilaflix.inventoryservice.service;

import com.simply.tp.sakilaflix.inventoryservice.dao.InventorySeviceDAO;
import com.simply.tp.sakilaflix.inventoryservice.entities.FilmList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by shreeharshashet on 2/7/18.
 */
@Component
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    InventorySeviceDAO movieSeviceDAO;

}
