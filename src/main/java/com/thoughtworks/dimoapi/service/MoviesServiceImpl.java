package com.thoughtworks.dimoapi.service;

import com.thoughtworks.dimoapi.entity.Movies;
import com.thoughtworks.dimoapi.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    MoviesRepository moviesRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Movies findBymovieId(long id) {
        return moviesRepository.findBymovieId(id);
    }
}
