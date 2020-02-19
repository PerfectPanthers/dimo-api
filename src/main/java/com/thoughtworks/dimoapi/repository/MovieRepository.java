package com.thoughtworks.dimoapi.repository;

import com.thoughtworks.dimoapi.entity.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {

    Movie findByMovieId(String movieId);
}
