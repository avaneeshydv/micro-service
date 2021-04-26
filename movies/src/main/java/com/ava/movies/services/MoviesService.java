package com.ava.movies.services;

import com.ava.movies.entity.Movies;

public interface MoviesService {

    Movies createMovie(Movies movies);
    Movies getMovieById(Movies movies);
}
