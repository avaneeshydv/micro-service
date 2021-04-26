package com.ava.movies.catalog.controller;

import com.ava.movies.catalog.entity.MovieRating;
import com.ava.movies.catalog.model.MovieCatalog;
import com.ava.movies.catalog.model.UserCatalog;
import com.ava.movies.catalog.services.MoviesRatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog")
public class MovieRateController {

    private final MoviesRatingService moviesRatingService;

    public MovieRateController(MoviesRatingService moviesRatingService) {
        this.moviesRatingService = moviesRatingService;
    }

    @PostMapping("/giverating")
    @ResponseBody
    public MovieRating giveRating(@RequestBody MovieRating rating) {
        return moviesRatingService.createRating(rating);
    }

    @GetMapping("/movie")
    public ResponseEntity<MovieCatalog> getMovieCatalog(@RequestParam("id") int id) {
        return new ResponseEntity<>(moviesRatingService.getMovieCatalog(id), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<UserCatalog> getUserCatalog(@RequestParam("id") int id) {
        return new ResponseEntity<>(moviesRatingService.getUserCatalog(id), HttpStatus.OK);
    }


}
