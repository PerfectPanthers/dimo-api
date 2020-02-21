package com.thoughtworks.dimoapi.service;

import com.thoughtworks.dimoapi.entity.Movie;

public interface MovieService {
    Movie findByMovieId(long id);
}
