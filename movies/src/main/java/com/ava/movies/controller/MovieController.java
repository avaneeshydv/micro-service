package com.ava.movies.controller;

import com.ava.movies.entity.Movies;
import com.ava.movies.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MoviesService moviesService;

    @PostMapping("/createmovie")
    @ResponseBody
    public Movies createMovie(@RequestBody Movies movies) {
        System.out.println(LocalDateTime.now());
        return moviesService.createMovie(movies);
    }

    @GetMapping("/getmovie")
    @ResponseBody
    public Movies createMovie(@RequestParam("id") int id) {
        Movies m = new Movies();
        m.setMovieId(id);
        return moviesService.getMovieById(m);
    }
}
