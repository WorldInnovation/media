package com.study.repository;

import com.study.model.Movie;

import java.util.List;

public interface MediaRepository {
    List<Movie> getAllMovies();

    List<Movie> getRandomMovies(int count);
}
