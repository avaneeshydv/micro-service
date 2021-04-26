package com.ava.movies.catalog.repo;

import java.util.List;

import com.ava.movies.catalog.entity.MovieRating;
import com.ava.movies.catalog.entity.RatingId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MoviesRatingRepository extends JpaRepository<MovieRating, RatingId> {

    List<MovieRating> findAllByMovie_MovieId(int id);
    List<MovieRating> findAllByUser_UserId(int id);
}
