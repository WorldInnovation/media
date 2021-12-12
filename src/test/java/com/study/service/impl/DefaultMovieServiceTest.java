package com.study.service.impl;


import com.study.model.Movie;
import com.study.repository.impl.DefaultMovieRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class DefaultMovieServiceTest {
    private static final List<Movie> movieReal = new ArrayList<>();
    private static final List<Movie> movieExpected = new ArrayList<>();
    private static final DefaultMovieRepository defaultMovieRepository = mock(DefaultMovieRepository.class);
    private static final DefaultMovieService movieService = new DefaultMovieService(defaultMovieRepository);

    @BeforeAll
    static void init() {
        Movie movie = new Movie();
        movie.setId(1);
        Movie movie2 = new Movie();
        movie2.setId(2);
        movieExpected.add(movie);
        movieExpected.add(movie2);

        Movie movie3 = new Movie();
        movie3.setId(1);
        Movie movie4 = new Movie();
        movie4.setId(2);
        movieReal.add(movie3);
        movieReal.add(movie4);

        Mockito.when(defaultMovieRepository.getAllMovies()).thenReturn(movieReal);
    }

    @Test
    void getAllMovies() {
        List<Movie> allMovies = movieService.getAllMovies();
        assertEquals(movieExpected, allMovies);
    }
}
