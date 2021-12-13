package com.study.repository.impl;

import com.study.model.Movie;
import com.study.repository.MediaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

@Repository
public class DefaultMovieRepository implements MediaRepository {
    private final static String SELECT_ALL = "SELECT ID, NAME_RU, NAME_EN, RELEASE_YEAR,  DESCRIPTION, RATING, PRICE" +
            ", PICTURE_PATH FROM MOVIES;";
    private final static String SELECT_RANDOM = "SELECT ID, NAME_RU, NAME_EN, RELEASE_YEAR,  DESCRIPTION, RATING, PRICE" +
            ", PICTURE_PATH FROM MOVIES ORDER BY random() LIMIT :count;";

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Movie> rowMapper;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DefaultMovieRepository(DataSource dataSource, RowMapper<Movie> rowMapper) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.rowMapper = rowMapper;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Movie> getAllMovies() {
        return jdbcTemplate.query(SELECT_ALL, rowMapper);
    }

    public List<Movie> getRandomMovies(int count) {
        return namedParameterJdbcTemplate.query(SELECT_RANDOM, Collections.singletonMap("count", count), rowMapper);
    }
}
