package com.thoughtworks.dimoapi.controller;

import com.thoughtworks.dimoapi.entity.Movies;
import com.thoughtworks.dimoapi.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    MoviesService moviesService;

    @GetMapping(value = "")
    public Movies getMovieById(@RequestParam(value="id") String movieId) {
        return moviesService.findBymovieId(Long.parseLong((movieId)));
    }
}
