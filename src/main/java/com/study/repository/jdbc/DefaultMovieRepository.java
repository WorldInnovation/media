package com.study.repository.jdbc;

import com.study.model.Movie;
import com.study.repository.MovieRepository;
import com.study.repository.mapper.MovieMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

@Slf4j
@Repository
public class DefaultMovieRepository implements MovieRepository {
    private final static String SELECT_ALL =
            "SELECT ID, NAME_RU, NAME_NATIVE, RELEASE_YEAR,   RATING, PRICE, PICTURE_PATH FROM MOVIES;";
    private final static String SELECT_RANDOM =
            "SELECT ID, NAME_RU, NAME_NATIVE, RELEASE_YEAR, RATING, PRICE, PICTURE_PATH FROM MOVIES ORDER BY random() LIMIT :count;";
    private final static String SELECT_BY_GENRE_ID = "SELECT M.ID, M.NAME_RU, M.NAME_NATIVE, M.RELEASE_YEAR, M.RATING, M.PRICE," +
            " M.PICTURE_PATH FROM MOVIES M INNER JOIN GENRE_TO_MOVIE GTM ON M.ID = GTM.MOVIE_ID WHERE GTM.GENRE_ID = :genreId;";
    private final static String SELECT_ALL_SORTED_BY_RATING =
            "SELECT ID, NAME_RU, NAME_NATIVE, RELEASE_YEAR,   RATING, PRICE, PICTURE_PATH FROM MOVIES ORDER BY RATING DESC;";
    private final static String SELECT_BY_GENRE_ID_ORDER_BY_RATING = "SELECT M.ID, M.NAME_RU, M.NAME_NATIVE, M.RELEASE_YEAR, M.RATING, M.PRICE," +
            " M.PICTURE_PATH FROM MOVIES M INNER JOIN GENRE_TO_MOVIE GTM ON M.ID = GTM.MOVIE_ID WHERE GTM.GENRE_ID = :genreId ORDER BY RATING DESC;";
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public static final RowMapper<Movie> MOVIE_MAPPER = new MovieMapper();

    public DefaultMovieRepository(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Movie> getAllMovies() {
        log.info("getAllMovies");
        return namedParameterJdbcTemplate.query(SELECT_ALL, MOVIE_MAPPER);
    }

    public List<Movie> getRandomMovies(int count) {
        log.info("getRandomMovies {}", count);
        return namedParameterJdbcTemplate.query(SELECT_RANDOM, Collections.singletonMap("count", count), MOVIE_MAPPER);
    }

    @Override
    public List<Movie> getMoviesByGenreId(Long genreId) {
        log.info("getMoviesByGenreId {}", genreId);
        return namedParameterJdbcTemplate.query(SELECT_BY_GENRE_ID, Collections.singletonMap("genreId", genreId), MOVIE_MAPPER);
    }

    @Override
    public List<Movie> getMoviesSortedByRating() {
        log.info("getMoviesSortedByRating");
        return namedParameterJdbcTemplate.query(SELECT_ALL_SORTED_BY_RATING, MOVIE_MAPPER);
    }

    @Override
    public List<Movie> getMoviesByGenreIdSortedByRating() {
        log.info("getMoviesByGenreIdSortedByRating");
        return namedParameterJdbcTemplate.query(SELECT_BY_GENRE_ID_ORDER_BY_RATING, MOVIE_MAPPER);
    }
}
