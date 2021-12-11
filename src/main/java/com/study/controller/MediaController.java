package com.study.controller;

import com.study.model.Movie;
import com.study.service.impl.DefaultMovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/v1/movie")
public class MediaController {
    private final DefaultMovieService defaultMovieService;

    public MediaController(DefaultMovieService defaultMovieService) {
        this.defaultMovieService = defaultMovieService;
    }

    @ResponseBody
    @GetMapping(produces = "application/json")
    public List<Movie> getAllMovies() {
        return defaultMovieService.getAllMovies();
    }
}
