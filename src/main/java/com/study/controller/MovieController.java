package com.study.controller;

import com.study.model.Movie;
import com.study.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/movie", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping(path = "/random/{count}")
    public List<Movie> getRandomMovies(@PathVariable int count) {
        return movieService.getRandomMovies(count);
    }

    @GetMapping(path = "/genre/{genreId}")
    public List<Movie> getMoviesByGenre(@PathVariable Long genreId) {
        return movieService.getMoviesByGenre(genreId);
    }

}
