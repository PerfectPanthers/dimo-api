package com.thoughtworks.dimoapi.service;

import com.thoughtworks.dimoapi.entity.Movie;
import com.thoughtworks.dimoapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository moviesRepository;

    @Override
    public Movie findByMovieId(long id) {
        return moviesRepository.findByMovieId(id);
    }
}
