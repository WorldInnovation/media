package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.study.config")
public class MovieApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class);
    }
}
