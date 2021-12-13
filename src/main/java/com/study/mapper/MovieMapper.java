package com.study.mapper;

import com.study.model.Movie;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class MovieMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Movie movie = new Movie();
        movie.setId(rs.getInt("ID"));
        movie.setNameRu(rs.getString("NAME_RU"));
        movie.setNameEn(rs.getString("NAME_EN"));
        movie.setReleaseYear(rs.getInt("RELEASE_YEAR"));
        movie.setRating(rs.getDouble("RATING"));
        movie.setPrice(rs.getDouble("PRICE"));
        movie.setPicturePath(rs.getString("PICTURE_PATH"));
        return movie;
    }
}
