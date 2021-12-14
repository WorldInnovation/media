package com.study.service.impl;

import com.study.model.Genre;
import com.study.repository.GenreRepository;
import com.study.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultGenreService implements GenreService {
    private final GenreRepository genreRepository;

    public List<Genre> getAllGenres() {
        return genreRepository.getAllGenres();
    }
}
