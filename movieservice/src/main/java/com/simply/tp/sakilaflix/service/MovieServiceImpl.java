package com.simply.tp.sakilaflix.service;

import com.simply.tp.sakilaflix.dao.MovieSeviceDAO;
import com.simply.tp.sakilaflix.entities.FilmList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by shreeharshashet on 2/7/18.
 */
@Component
public class MovieServiceImpl implements MovieService{
    @Autowired
    MovieSeviceDAO movieSeviceDAO;

    @Override
    public List<FilmList> searchFilmsByTitle(String title) {
        return movieSeviceDAO.searchFilmsByTitle(title);
    }
}
