package com.study.mapper;

import com.study.model.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
class MovieMapperTest {

    @Mock
    ResultSet resultSetMock;

    MockitoSession mockitoSession;
    MovieMapper movieMapper = new MovieMapper();

    @BeforeEach
    void before() {
        mockitoSession = Mockito.mockitoSession().initMocks(this).startMocking();
    }

    @AfterEach
    void after() {
        mockitoSession.finishMocking();
    }
    @Test
    void mapRowTest() throws SQLException {
        Mockito.when(resultSetMock.getInt("ID")).thenReturn(1);
        Mockito.when(resultSetMock.getString("NAME_RU")).thenReturn("Ру1");
        Mockito.when(resultSetMock.getString("NAME_EN")).thenReturn("En1");
        Mockito.when(resultSetMock.getInt("RELEASE_YEAR")).thenReturn(2001);
        Mockito.when(resultSetMock.getDouble("RATING")).thenReturn(10.00);
        Mockito.when(resultSetMock.getDouble("PRICE")).thenReturn(1.00);
        Mockito.when(resultSetMock.getString("PICTURE_PATH")).thenReturn("path1");

        Movie movie = new Movie();
        movie.setId(1);
        movie.setNameRu("Ру1");
        movie.setNameEn("En1");
        movie.setReleaseYear(2001);
        movie.setPrice(1.00);
        movie.setRating(10.00);
        movie.setPicturePath("path1");


        Movie movieActual = movieMapper.mapRow(resultSetMock, 10);
        assertEquals(movie, movieActual);
    }
}