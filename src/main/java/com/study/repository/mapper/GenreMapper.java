package com.study.repository.mapper;

import com.study.model.Genre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@JdbcMapper
public class GenreMapper implements RowMapper<Genre> {
    @Override
    public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
        Genre genre = new Genre();
        genre.setId(rs.getInt("ID"));
        genre.setGenreName(rs.getString("GENRE_NAME"));
        return genre;

    }
}