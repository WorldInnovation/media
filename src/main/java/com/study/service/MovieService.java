package com.study.service;

import com.study.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    List<Movie> getRandomMovies(int count);

    List<Movie> getMoviesByGenre(Long genreId);
}
