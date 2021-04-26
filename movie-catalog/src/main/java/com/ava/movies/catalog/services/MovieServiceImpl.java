package com.ava.movies.catalog.services;

import java.time.LocalDateTime;

import com.ava.movies.catalog.entity.Movies;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieServiceImpl implements MovieService {

    private final RestTemplate restTemplate;

    @Value("${movie.url}")
    private String movieUrl;

    public MovieServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallBackMovie")
    public Movies getMovieInfo(int id) {
        String url = movieUrl + "getmovie?id=" + id;
        return restTemplate.getForObject(url, Movies.class);
    }

    private Movies fallBackMovie(int id){
        Movies m = new Movies();
        m.setMovieId(id);
        m.setMovieName("No Movie found");
        m.setMovieDescription("Mo Description");
        m.setReleaseDate(LocalDateTime.now());
        return m;
    }
}
