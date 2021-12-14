package com.study.repository.jdbc;

import com.study.repository.mapper.GenreMapper;
import com.study.model.Genre;
import com.study.repository.GenreRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DefaultGenreRepository implements GenreRepository {
    private final static String SELECT_ALL_GENRES = "SELECT ID, GENRE_NAME FROM GENRES;";
    private final static RowMapper<Genre> GENRE_MAPPER = new GenreMapper();
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DefaultGenreRepository(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Genre> getAllGenres() {
        return namedParameterJdbcTemplate.query(SELECT_ALL_GENRES, GENRE_MAPPER);
    }
}
