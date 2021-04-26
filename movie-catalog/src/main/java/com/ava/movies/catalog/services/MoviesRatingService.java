package com.ava.movies.catalog.services;

import com.ava.movies.catalog.entity.MovieRating;
import com.ava.movies.catalog.model.MovieCatalog;
import com.ava.movies.catalog.model.UserCatalog;

public interface MoviesRatingService {

    MovieRating createRating(MovieRating rating);

    MovieCatalog getMovieCatalog(int movieId);
    UserCatalog getUserCatalog(int userId);
}
