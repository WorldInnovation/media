package com.study.service;

import com.study.dto.FinedMoviesRequestData;
import com.study.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies(FinedMoviesRequestData finedMoviesRequestData);

    List<Movie> getRandomMovies(int count);

    List<Movie> getMoviesByGenre(FinedMoviesRequestData finedMoviesRequestData);
}
