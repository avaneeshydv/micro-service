package com.ava.movies.catalog.services;

import com.ava.movies.catalog.entity.MovieRating;
import com.ava.movies.catalog.entity.Movies;
import com.ava.movies.catalog.entity.Users;
import com.ava.movies.catalog.model.MovieCatalog;
import com.ava.movies.catalog.model.UserCatalog;
import com.ava.movies.catalog.repo.MoviesRatingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MoviesRatingServiceImpl implements MoviesRatingService {

    private final MoviesRatingRepository repository;
    private final MovieService movieService;
    private final UserService userService;

    public MoviesRatingServiceImpl(MoviesRatingRepository repository
            , MovieService movieService
            , UserService userService) {
        this.repository = repository;
        this.movieService = movieService;
        this.userService = userService;
    }

    @Override
    public MovieRating createRating(MovieRating rating) {
        return repository.save(rating);
    }

    @Override
    public MovieCatalog getMovieCatalog(int movieId) {

        //get movie info using movie service
        Movies movieInfo = movieService.getMovieInfo(movieId);
        MovieCatalog catalog = new MovieCatalog();
        //populate movie info in catalog
        if (movieInfo != null) {
            catalog.setMovieName(movieInfo.getMovieName());
            catalog.setDescription(movieInfo.getMovieDescription());
            catalog.setReleaseDate(movieInfo.getReleaseDate().toLocalDate().toString());
        }
        //populate user info in catalog using DB
        List<MovieRating> allRatingForMovie = repository.findAllByMovie_MovieId(movieId);

        if (allRatingForMovie.size() > 0) {
            List<Users> allUser = new ArrayList<>();
            for (MovieRating rating : allRatingForMovie) {
                Users user = rating.getUser();
                allUser.add(user);
            }
            catalog.setRatingProviders(allUser);
        }

        return catalog;
    }

    @Override
    public UserCatalog getUserCatalog(int userId) {

        //get user details
        Users user = userService.getUser(userId);

        UserCatalog catalog = new UserCatalog();
        if (user != null) {
            catalog.setName(user.getFirstName() + " " + user.getLastName());
            catalog.setEmail(user.getEmail());
            catalog.setAddress(user.getAddress());
        }
        //get all rated movies by this user
        List<MovieRating> allRatingForMovie = repository.findAllByUser_UserId(userId);
        if (allRatingForMovie.size() > 0) {
            List<Movies> movies = new ArrayList<>();
            for (MovieRating rating : allRatingForMovie) {
                Movies movie = rating.getMovie();
                movie.setRating(rating.getRating());
                movie.setComment(rating.getReason());
                movies.add(movie);
            }
            catalog.setRatedMovies(movies);
        }
        return catalog;
    }

}
