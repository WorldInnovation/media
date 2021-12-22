package com.study.controller;

import com.study.config.MovieConfig;
import com.study.config.RootConfig;
import com.study.model.Movie;
import com.study.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {MovieConfig.class, RootConfig.class})
class MovieControllerITest {
    private MockMvc mockMvc;
    private final MovieService movieService = mock(MovieService.class);

    @Autowired
    private WebApplicationContext webApplicationContext;

    List<Movie> movieList = new ArrayList<>();

    @BeforeEach
    public void setup() {
        Movie movie = new Movie();
        movie.setId(1);
        movie.setNameRu("Ру1");
        movie.setNameNative("En1");
        movie.setReleaseYear(2001);
        movie.setPrice(1.00);
        movie.setRating(10.00);
        movie.setPicturePath("path1");

        Movie movie2 = new Movie();
        movie2.setId(1);
        movie2.setNameRu("Ру2");
        movie2.setNameNative("En2");
        movie2.setReleaseYear(2002);
        movie2.setPrice(2.00);
        movie2.setRating(2.00);
        movie2.setPicturePath("path1");

        movieList.add(movie);
        movieList.add(movie2);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void findAllServiceShouldShouldReturnRightJsonAndOk() throws Exception {
        mockMvc.perform(get("/api/v1/movie"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void findRandomShouldReturnRightJsonAndOk() throws Exception {
        mockMvc.perform(get("/api/v1/movie/random/3"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void findAllGenreShouldReturnRightJsonAndOk() throws Exception {
        mockMvc.perform(get("/api/v1/movie/random/3"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void findByGenreShouldReturnRightJsonAndOk() throws Exception {
        mockMvc.perform(get("/api/v1//movie/genre/3"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

   @Test
    public void getAllMoviesSortedByRatingTest() throws Exception {
        mockMvc.perform(get("/api/v1//movie?rating=desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

  @Test
    public void getAllMoviesSortedByRatingHiCaseTest() throws Exception {
        mockMvc.perform(get("/api/v1//movie?rating=DESC"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
  @Test
    public void getAllMoviesByGenreSortedByRatingTest() throws Exception {
        mockMvc.perform(get("/api/v1//movie/genre/5?rating=desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

  @Test
    public void getAllMoviesByGenreSortedByRatingHiCaseTest() throws Exception {
        mockMvc.perform(get("/api/v1//movie/genre/3?rating=DESC"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}