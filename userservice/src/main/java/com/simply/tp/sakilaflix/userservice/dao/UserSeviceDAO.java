package com.simply.tp.sakilaflix.userservice.dao;

import com.simply.tp.sakilaflix.userservice.dto.CustomerDTO;
import com.simply.tp.sakilaflix.userservice.entities.Customer;

/**
 * Created by shreeharshashet on 2/7/18.
 */
public interface UserSeviceDAO {
    public CustomerDTO searchCustomer(String firs_name);

    public Customer getCustomerById(int customerId);
}
