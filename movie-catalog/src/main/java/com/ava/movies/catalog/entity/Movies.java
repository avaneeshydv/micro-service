package com.ava.movies.catalog.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class Movies {

    @Id
    @Column(name = "MOVIE_ID")
    private int movieId;
    @Column(name = "MOVIE_NM")
    private String movieName;
    @Column(name = "MOVIE_DESC")
    private String movieDescription;
    @Column(name = "RELEASE_DT")
    private LocalDateTime releaseDate;

    @Transient
    private int rating;
    @Transient
    private String comment;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Movies [comment=" + comment + ", movieDescription=" + movieDescription + ", movieId=" + movieId
                + ", movieName=" + movieName + ", rating=" + rating + ", releaseDate=" + releaseDate + "]";
    }

    
}
