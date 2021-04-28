package com.ava.movies.catalog.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RatingId  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "USER_ID")
    private int userId;
    @Column(name = "MOVIE_ID")
    private int movieId;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RatingId)) return false;
        RatingId ratingId = (RatingId) o;
        return getUserId() == ratingId.getUserId() &&
                getMovieId() == ratingId.getMovieId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getMovieId());
    }

    @Override
    public String toString() {
        return "RatingId [movieId=" + movieId + ", userId=" + userId + "]";
    }

    
    
}
