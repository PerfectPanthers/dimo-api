package com.thoughtworks.dimoapi.controller;

import com.thoughtworks.dimoapi.entity.Movie;
import com.thoughtworks.dimoapi.entity.Preference;
import com.thoughtworks.dimoapi.model.Response;
import com.thoughtworks.dimoapi.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @GetMapping(path = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getMoviesByPreferences(@RequestParam("email") String email) {
        if (email == null || email.isEmpty()){
            return new ResponseEntity("Please Enter a valid email", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(dashboardService.getMoviesByPreferences(email), HttpStatus.OK);
    }
}
