package com.study.service.impl;

import com.study.model.Movie;
import com.study.repository.MovieRepository;
import com.study.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultMovieService implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    @Override
    public List<Movie> getRandomMovies(int count) {
        return movieRepository.getRandomMovies(count);
    }

    @Override
    public List<Movie> getMoviesByGenre(Long genreId) {
        return movieRepository.getMoviesByGenreId(genreId);
    }

}
