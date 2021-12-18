package com.study.service.impl;

import com.study.model.Genre;
import com.study.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CachedGenreService implements GenreService {
    private final GenreService genreService;
    private volatile List<Genre> genreCacheList;

    @Override
    public List<Genre> getAllGenres() {
        return  Collections.unmodifiableList(genreCacheList);
    }

    @PostConstruct
    public void loadCache() {genreCacheList = genreService.getAllGenres();}

    @Scheduled(cron = "* * 0/4 * *")
    public void scheduleTaskRefreshCache() {
        genreCacheList = genreService.getAllGenres();
    }
}
