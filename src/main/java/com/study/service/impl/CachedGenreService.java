package com.study.service.impl;

import com.study.model.Genre;
import com.study.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@Primary
@AllArgsConstructor
public class CachedGenreService implements GenreService {
    private final GenreService genreService;
    private volatile List<Genre> genreCacheList;

    @Override
    public List<Genre> getAllGenres() {
        return new CopyOnWriteArrayList<>(genreCacheList);
    }

    @Scheduled(fixedDelay = 4 * 60 * 60 * 1000)
    @PostConstruct
    public void scheduleTaskRefreshCache() {
        genreCacheList = genreService.getAllGenres();
    }
}
