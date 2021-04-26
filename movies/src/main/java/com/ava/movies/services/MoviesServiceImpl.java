package com.ava.movies.services;

import com.ava.movies.entity.Movies;
import com.ava.movies.repo.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    private MoviesRepository repository;

    @Override
    public Movies createMovie(Movies movies) {
        return repository.save(movies);
    }

    @Override
    public Movies getMovieById(Movies movies) {
        return repository.findById(movies.getMovieId()).get();
    }
}
