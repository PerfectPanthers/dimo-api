package com.thoughtworks.dimoapi.controller;

import com.thoughtworks.dimoapi.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    MoviesService moviesService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getMovieById(@RequestParam(value = "id") String movieId) {
        if (movieId == null || movieId.equals("")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return moviesService.findBymovieId(Long.parseLong((movieId)));
    }
}
