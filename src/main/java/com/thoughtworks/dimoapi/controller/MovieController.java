package com.thoughtworks.dimoapi.controller;

import com.thoughtworks.dimoapi.model.Response;
import com.thoughtworks.dimoapi.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    MoviesService moviesService;

    @GetMapping(value = "")
    public Object getMovieById(@RequestParam(value="id") String movieId) {
        if(movieId == null || movieId.equals("")){
            return new ResponseEntity<>(new Response(false,"Empty Movie Id Passed"), HttpStatus.BAD_REQUEST);
        }
        return moviesService.findBymovieId(Long.parseLong((movieId)));
    }
}
