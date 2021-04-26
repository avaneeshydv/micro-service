package com.ava.movies.catalog.model;

import com.ava.movies.catalog.entity.Movies;

import java.util.List;

public class UserCatalog {

    private String name;
    private String email;
    private String address;

    private List<Movies> ratedMovies;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Movies> getRatedMovies() {
        return ratedMovies;
    }

    public void setRatedMovies(List<Movies> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }
}
