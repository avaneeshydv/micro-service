package com.ava.movies.catalog.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "MOVIES_RATE")
public class MovieRating {

    @EmbeddedId
    private RatingId ratingId;
    private int rating;
    private String reason;

    @ManyToOne
    @JoinColumn(name = "USER_ID", insertable = false, updatable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "MOVIE_ID", insertable = false, updatable = false)
    private Movies movie;

    public RatingId getRatingId() {
        return ratingId;
    }

    public void setRatingId(RatingId ratingId) {
        this.ratingId = ratingId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }
}
