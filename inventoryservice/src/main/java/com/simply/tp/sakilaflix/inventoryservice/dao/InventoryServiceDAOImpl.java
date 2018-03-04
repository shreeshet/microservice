package com.simply.tp.sakilaflix.inventoryservice.dao;

import com.simply.tp.sakilaflix.inventoryservice.dto.InventoryDetails;
import com.simply.tp.sakilaflix.inventoryservice.entities.Address;
import com.simply.tp.sakilaflix.inventoryservice.entities.FilmList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by shreeharshashet on 2/7/18.
 */
@Component
public class InventoryServiceDAOImpl implements InventorySeviceDAO {
    protected Logger logger = LoggerFactory.getLogger(InventoryServiceDAOImpl.class);

    @PersistenceContext
    EntityManager em;

    @Override

    public List<InventoryDetails> searchInventory(int filmId) {

        String inventorySQL = "select f.film_id,f.rental_duration,inv.inventory_id,inv.store_id,inv.last_update," +
                "addr.location from film f join inventory inv on inv.film_id=f.film_id " +
                "join store str on str.store_id = inv.store_id join address addr on addr.address_id = str.address_id " +
                "where (select count(rental_id) from rental r where r.inventory_id=inv.inventory_id and r.return_date IS NULl) = 0 " +
                "and  f.film_id = ";

        String inSQL = "select " +
                "f.film_id as film_id," +
                "f.rental_duration as rental_duration," +
                "inv.inventory_id as inventory_id," +
                "inv.store_id as store_id," +
                "inv.last_update as last_update," +
                "addr.location as location " +
                "from film f join inventory inv on inv.film_id=f.film_id " +
                "join store str on str.store_id = inv.store_id join address addr on addr.address_id = str.address_id " +
                "where (select count(rental_id) from rental r where r.inventory_id=inv.inventory_id and r.return_date IS NULl) = 0 " +
                "and f.film_id = ";




        Query qry = em.createNativeQuery(inSQL + filmId,"InventoryResults");

        List<InventoryDetails> res = qry.getResultList();

        return res;
    }
}
