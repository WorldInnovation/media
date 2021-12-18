package com.study.repository;

import com.study.model.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> getAllMovies();

    List<Movie> getRandomMovies(int count);

    List<Movie> getMoviesByGenreId(Long genreId);

    List<Movie> getMoviesSortedByRating();

    List<Movie> getMoviesByGenreIdSortedByRating();
}
