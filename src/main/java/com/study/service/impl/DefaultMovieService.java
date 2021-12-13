package com.study.service.impl;

import com.study.model.Movie;
import com.study.repository.impl.DefaultMovieRepository;
import com.study.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMovieService implements MovieService {
    private final DefaultMovieRepository movieRepository;

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
