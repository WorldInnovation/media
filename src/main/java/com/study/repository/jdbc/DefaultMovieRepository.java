package com.study.repository.jdbc;

import com.study.model.Movie;
import com.study.repository.MovieRepository;
import com.study.repository.mapper.MovieMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

@Repository
public class DefaultMovieRepository implements MovieRepository {
    private final static String SELECT_ALL = "SELECT ID, NAME_RU, NAME_NATIVE, RELEASE_YEAR,   RATING, PRICE, PICTURE_PATH FROM MOVIES;";
    private final static String SELECT_RANDOM = "SELECT ID, NAME_RU, NAME_NATIVE, RELEASE_YEAR, RATING, PRICE, PICTURE_PATH FROM MOVIES ORDER BY random() LIMIT :count;";
    private final static String SELECT_BY_GENRE_ID = "SELECT M.ID, M.NAME_RU, M.NAME_NATIVE, M.RELEASE_YEAR, M.RATING, M.PRICE," +
            " M.PICTURE_PATH FROM MOVIES M INNER JOIN GENRE_TO_MOVIE GTM ON M.ID = GTM.MOVIE_ID WHERE GTM.GENRE_ID = :genreId;";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public static final RowMapper<Movie> MOVIE_MAPPER = new MovieMapper();

    public DefaultMovieRepository(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Movie> getAllMovies() {
        return namedParameterJdbcTemplate.query(SELECT_ALL, MOVIE_MAPPER);
    }

    public List<Movie> getRandomMovies(int count) {
        return namedParameterJdbcTemplate.query(SELECT_RANDOM, Collections.singletonMap("count", count), MOVIE_MAPPER);
    }

    @Override
    public List<Movie> getMoviesByGenreId(Long genreId) {
        return namedParameterJdbcTemplate.query(SELECT_BY_GENRE_ID, Collections.singletonMap("genreId", genreId), MOVIE_MAPPER);
    }
}
