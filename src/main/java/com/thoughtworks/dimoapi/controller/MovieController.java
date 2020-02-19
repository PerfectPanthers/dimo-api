package com.thoughtworks.dimoapi.controller;

import com.thoughtworks.dimoapi.entity.Movie;
import com.thoughtworks.dimoapi.model.LoginRequest;
import com.thoughtworks.dimoapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping(path = "/details", produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie doLogin(@RequestParam String movieId) {
        return  movieService.findByMovieId(movieId);
    }
}
