package com.simply.tp.sakilaflix.userservice.customer;

import com.simply.tp.sakilaflix.userservice.dao.UserSeviceDAO;
import com.simply.tp.sakilaflix.userservice.dto.CustomerDTO;
import com.simply.tp.sakilaflix.userservice.entities.Customer;
import com.simply.tp.sakilaflix.userservice.service.InventoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shreeharshashet on 2/6/18.
 */
@RestController
public class UserController {
    protected Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    InventoryServiceImpl movieService;

    @Autowired
    UserSeviceDAO movieSeviceDAO;

    @RequestMapping(value="/customer/first_name/{name}",method=RequestMethod.GET)
    public CustomerDTO getCustomerByFirstName(@PathVariable("name")String firs_name){
        return movieSeviceDAO.searchCustomer(firs_name);
    };

    @RequestMapping(value="/customer/{id}",method=RequestMethod.GET)
    public Customer getCustomer(@PathVariable("id") int customerId){
        return movieSeviceDAO.getCustomerById(customerId);
    };

}
