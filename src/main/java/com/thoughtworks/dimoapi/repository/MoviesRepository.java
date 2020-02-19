package com.thoughtworks.dimoapi.repository;


import com.thoughtworks.dimoapi.entity.Movies;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends MongoRepository<Movies,String>{
    Movies findBymovieId(long Id);
}
