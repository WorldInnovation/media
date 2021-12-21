package com.study.controller;

import com.study.dto.FinedMoviesRequestData;
import com.study.model.Movie;
import com.study.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/movie", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies(
            @RequestParam(name = "rating", required = false) String ratingParam) {
        return movieService.getAllMovies(FinedMoviesRequestData.builder()
                .ratingSortDirection(ratingParam)
                .build());
    }

    @GetMapping(path = "/random/{count}")
    public List<Movie> getRandomMovies(@PathVariable int count) {
        return movieService.getRandomMovies(count);
    }

    @GetMapping(path = "/genre/{genreId}")
    public List<Movie> getMoviesByGenre(@PathVariable Long genreId,
                                        @RequestParam(name = "rating", required = false) String ratingParam) {
        return movieService.getMoviesByGenre(FinedMoviesRequestData.builder()
                .ratingSortDirection(ratingParam)
                .genreId(genreId)
                .build());
    }

}
