package com.thoughtworks.dimoapi.service;

import com.thoughtworks.dimoapi.entity.Movie;
import com.thoughtworks.dimoapi.entity.User;

public interface MovieService {
    Movie findByMovieId(String movieId);
}
