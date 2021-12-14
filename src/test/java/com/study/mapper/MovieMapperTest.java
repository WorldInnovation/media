package com.study.mapper;

import com.study.model.Movie;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.ResultSet;
import java.sql.SQLException;

@ExtendWith(MockitoExtension.class)
class MovieMapperTest {

    @Mock
    ResultSet resultSetMock;

    MovieMapper movieMapper = new MovieMapper();

    @Test
    void mapRowTest() throws SQLException {
        Mockito.when(resultSetMock.getInt("ID")).thenReturn(1);
        Mockito.when(resultSetMock.getString("NAME_RU")).thenReturn("Ру1");
        Mockito.when(resultSetMock.getString("NAME_NATIVE")).thenReturn("En1");
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
        Assertions.assertEquals(movie, movieActual);
    }
}