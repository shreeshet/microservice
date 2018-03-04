package com.simply.tp.sakilaflix.inventoryservice.inventory;

import com.simply.tp.sakilaflix.inventoryservice.dao.InventorySeviceDAO;
import com.simply.tp.sakilaflix.inventoryservice.dto.InventoryDetails;
import com.simply.tp.sakilaflix.inventoryservice.entities.Address;
import com.simply.tp.sakilaflix.inventoryservice.entities.FilmList;
import com.simply.tp.sakilaflix.inventoryservice.service.InventoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by shreeharshashet on 2/6/18.
 */
@RestController
public class InventoryController {
    protected Logger logger = LoggerFactory.getLogger(InventoryController.class);


    @Autowired
    InventoryServiceImpl movieService;

    @Autowired
    InventorySeviceDAO movieSeviceDAO;

    @RequestMapping(value="/hello/{name}",method=RequestMethod.GET)
    public String sayHello(@PathVariable("name") String name){
        return "Hello "+ name;
    }

    @RequestMapping(value="/inventory/{fid}",method=RequestMethod.GET)
    public List<InventoryDetails> getFileById(@PathVariable("fid")int fid){
        return movieSeviceDAO.searchInventory(fid);
    };


}
