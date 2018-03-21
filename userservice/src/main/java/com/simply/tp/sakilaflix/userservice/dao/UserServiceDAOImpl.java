package com.simply.tp.sakilaflix.userservice.dao;

import com.simply.tp.sakilaflix.userservice.dto.CustomerDTO;
import com.simply.tp.sakilaflix.userservice.entities.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by shreeharshashet on 2/7/18.
 */
@Component
public class UserServiceDAOImpl implements UserSeviceDAO {
    protected Logger logger = LoggerFactory.getLogger(UserServiceDAOImpl.class);

    @PersistenceContext
    EntityManager em;

    @Override

    public CustomerDTO searchCustomer(String firs_name) {


        String inSQL = "select " +
                "c.customer_id as customer_id," +
                "c.store_id as store_id, " +
                "c.first_name as first_name, " +
                "c.last_name as last_name, " +
                "c.email as email, " +
                //"c.address_id as address_id, " +
                "c.active as active, " +
                "c.create_date as create_date, " +
                "c.last_update as last_update " +
                "FROM customer c " +
                "WHERE c.active=1 AND " +
                "c.first_name=";



        Query qry = em.createNativeQuery(inSQL + "'"+firs_name.toUpperCase()+"'","CustomerResults");
        CustomerDTO cus = (CustomerDTO)qry.getSingleResult();

        return cus;
    }

    @Override
    public Customer getCustomerById(int customerId) {
        Query qry = em.createNamedQuery("Customer.findById");
        qry.setParameter("customerId",customerId);
        Customer cus = (Customer)qry.getSingleResult();
        return cus;
    }
}
