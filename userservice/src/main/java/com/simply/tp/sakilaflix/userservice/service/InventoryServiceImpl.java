package com.simply.tp.sakilaflix.userservice.service;

import com.simply.tp.sakilaflix.userservice.dao.UserSeviceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by shreeharshashet on 2/7/18.
 */
@Component
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    UserSeviceDAO movieSeviceDAO;

}
