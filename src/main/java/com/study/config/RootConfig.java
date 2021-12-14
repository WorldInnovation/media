package com.study.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan({"com.study.service", "com.study.repository"})
public class RootConfig implements WebMvcConfigurer {

    @Bean
    public DataSource dataSource(@Value("${db.username}") String userName
            , @Value("${db.password}") String password
            , @Value("${db.url}") String url
            , @Value("${db.driver.class}") String driverClassName
            , @Value("${db.max.pool.size}") int maxPoolSize
    ) {
        HikariConfig configuration = new HikariConfig();
        configuration.setUsername(userName);
        configuration.setPassword(password);
        configuration.setJdbcUrl(url);
        configuration.setDriverClassName(driverClassName);
        configuration.setMaximumPoolSize(maxPoolSize);
        return new HikariDataSource(configuration);
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
