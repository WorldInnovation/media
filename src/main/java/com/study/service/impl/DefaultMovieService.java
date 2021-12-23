package com.study.service.impl;

import com.study.dto.FinedMoviesRequestData;
import com.study.model.Movie;
import com.study.repository.MovieRepository;
import com.study.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DefaultMovieService implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies(FinedMoviesRequestData finedMoviesRequestData) {
        if (finedMoviesRequestData.getRatingSortDirection() != null) {
            String rating = finedMoviesRequestData.getRatingSortDirection();
            if (Objects.equals(rating.toLowerCase(), "desc")) {
                return movieRepository.getMoviesSortedByRating();
            }
        }

        return movieRepository.getAllMovies();
    }

    @Override
    public List<Movie> getRandomMovies(int count) {
        return movieRepository.getRandomMovies(count);
    }

    @Override
    public List<Movie> getMoviesByGenre(FinedMoviesRequestData finedMoviesRequestData) {
        if (finedMoviesRequestData.getRatingSortDirection() != null) {
            String rating = finedMoviesRequestData.getRatingSortDirection();
            if (Objects.equals(rating.toLowerCase(), "desc")) {
                return movieRepository.getMoviesByGenreIdSortedByRating(finedMoviesRequestData.getGenreId());
            }
        }

        return movieRepository.getMoviesByGenreId(finedMoviesRequestData.getGenreId());
    }

}
