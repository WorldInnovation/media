package com.study.service.impl;

import com.study.model.Genre;
import com.study.repository.jdbc.DefaultGenreRepository;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
class DefaultGenreServiceTest {

    private DefaultGenreRepository defaultGenreRepository;

    @Container
    public static PostgreSQLContainer<?> container = new PostgreSQLContainer<>(DockerImageName.parse("postgres:12.7"))
            .withUsername("developer")
            .withPassword("developer")
            .withDatabaseName("testDb");

    @BeforeEach
    void init() {
        HikariConfig config = new HikariConfig();
        config.setUsername(container.getUsername());
        config.setPassword(container.getPassword());
        config.setJdbcUrl(container.getJdbcUrl());
        config.setDriverClassName(container.getDriverClassName());
        HikariDataSource dataSource = new HikariDataSource(config);

        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .load();
        flyway.migrate();

        defaultGenreRepository = new DefaultGenreRepository(new NamedParameterJdbcTemplate(new JdbcTemplate(dataSource)));
    }

    @Test
    void testGetAllGenresReturnAllGenres() {
        List<Genre> genres = defaultGenreRepository.getAllGenres();

        assertEquals(15, genres.size());

    }

}
