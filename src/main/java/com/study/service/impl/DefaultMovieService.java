package com.study.service.impl;

import com.study.model.Movie;
import com.study.repository.MovieRepository;
import com.study.repository.jdbc.DefaultMovieRepository;
import com.study.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMovieService implements MovieService {
    private final MovieRepository movieRepository;

    public DefaultMovieService(DefaultMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    @Override
    public List<Movie> getRandomMovies(int count) {
        return movieRepository.getRandomMovies(count);
    }

}
