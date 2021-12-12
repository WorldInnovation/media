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
@ComponentScan({"com.study.model", "com.study.repository"})
public class RootContext implements WebMvcConfigurer {
    @Value("${db.username}")
    private String userName;
    @Value("${db.password}")
    private String password;
    @Value("${db.url}")
    private String url;
    @Value("${db.driver.class}")
    private String driverClassName;

    @Bean
    public DataSource getDataSource() {
        HikariConfig configuration = new HikariConfig();
        configuration.setUsername(userName);
        configuration.setPassword(password);
        configuration.setJdbcUrl(url);
        configuration.setDriverClassName(driverClassName);
        return new HikariDataSource(configuration);
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }
}
