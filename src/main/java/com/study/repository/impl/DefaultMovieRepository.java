package com.study.repository.impl;

import com.study.model.Movie;
import com.study.repository.MediaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DefaultMovieRepository implements MediaRepository {
    private final static String SELECT_ALL = "SELECT ID, NAME_RU, NAME_EN, RELEASE_YEAR,  DESCRIPTION, RATING, PRICE, PICTURE_PATH FROM MOVIES;";
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Movie> rowMapper;

    public DefaultMovieRepository(DataSource dataSource, RowMapper<Movie> rowMapper) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.rowMapper = rowMapper;
    }

    public List<Movie> getAllMovies() {
        return jdbcTemplate.query(SELECT_ALL, rowMapper);
    }
}
