package com.ava.movies.catalog.model;

import com.ava.movies.catalog.entity.Users;

import java.util.List;

public class MovieCatalog {

    private String movieName;
    private String releaseDate;
    private String description;
    private List<Users> ratingProviders;


    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Users> getRatingProviders() {
        return ratingProviders;
    }

    public void setRatingProviders(List<Users> ratingProviders) {
        this.ratingProviders = ratingProviders;
    }
}
