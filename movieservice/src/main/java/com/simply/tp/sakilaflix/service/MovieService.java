package com.simply.tp.sakilaflix.service;

import com.simply.tp.sakilaflix.entities.FilmList;

import java.util.List;

/**
 * Created by shreeharshashet on 2/6/18.
 */
public interface MovieService {
    List<FilmList> searchFilmsByTitle(String title);

}
