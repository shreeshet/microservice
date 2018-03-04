package com.simply.tp.sakilaflix.dao;

import com.simply.tp.sakilaflix.entities.Address;
import com.simply.tp.sakilaflix.entities.FilmList;

import java.util.List;

/**
 * Created by shreeharshashet on 2/7/18.
 */
public interface MovieSeviceDAO {
    List<FilmList> searchFilmsByTitle(String title);

    FilmList getFileById(int fid);

    Address getAnAddres(int addressId);
}
