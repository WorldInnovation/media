package com.study.repository.mapper;

import com.study.model.Genre;
import com.study.model.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GenreMapperTest {

    @Mock
    ResultSet resultSetMock;

    GenreMapper genreMapper = new GenreMapper();

    @Test
    void mapRow() throws SQLException {
        Mockito.when(resultSetMock.getInt("ID")).thenReturn(1);
        Mockito.when(resultSetMock.getString("GENRE_NAME")).thenReturn("KinDzaDza");

        Genre genre = new Genre();
        genre.setId(1);
        genre.setGenreName("KinDzaDza");

        Genre movieActual = genreMapper.mapRow(resultSetMock, 2);
        Assertions.assertEquals(genre, movieActual);
    }

    @Test
    void mapRowIncorrectId() throws SQLException {
        Mockito.when(resultSetMock.getInt("ID")).thenReturn(3);
        Mockito.when(resultSetMock.getString("GENRE_NAME")).thenReturn("KinDzaDza");

        Genre genre = new Genre();
        genre.setId(1);
        genre.setGenreName("KinDzaDza");

        Genre movieActual = genreMapper.mapRow(resultSetMock, 2);
        Assertions.assertNotEquals(genre, movieActual);
    }

   @Test
    void mapRowIncorrectName() throws SQLException {
        Mockito.when(resultSetMock.getInt("ID")).thenReturn(3);
        Mockito.when(resultSetMock.getString("GENRE_NAME")).thenReturn("KinDzaDza");

        Genre genre = new Genre();
        genre.setId(1);
        genre.setGenreName("CheehPihProtivBarig");

        Genre movieActual = genreMapper.mapRow(resultSetMock, 2);
        Assertions.assertNotEquals(genre, movieActual);
    }


}