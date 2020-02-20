package com.thoughtworks.dimoapi.service;

import com.thoughtworks.dimoapi.entity.Movies;

public interface MoviesService {
    Movies findBymovieId(long id);
}
