package com.thoughtworks.dimoapi.controller;

import com.thoughtworks.dimoapi.entity.User;
import com.thoughtworks.dimoapi.model.LoginRequest;
import com.thoughtworks.dimoapi.model.Response;
import com.thoughtworks.dimoapi.service.DashboardService;
import com.thoughtworks.dimoapi.service.UserService;
import com.thoughtworks.dimoapi.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    DashboardService dashboardService;

    @GetMapping(value = "/hello")
    public String sayHello() {
        return "hello";
    }

    @PostMapping(path = "/signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> createUser(@RequestBody User user) {
        if (userService.findByEmail(user.getEmail()) == null) {
            User dbUser = userService.save(user);
            return new ResponseEntity<>(new Response(dbUser.getUserId(), dbUser.getName(), dbUser.getEmail()), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Response> login(@RequestBody LoginRequest credential) {

        User user = userService.findByEmail(credential.getEmail());
        if (user != null) {
            if (PasswordUtils.decrypt(user.getPassword()).equals(credential.getPassword())) {
                return new ResponseEntity<>(new Response(user.getUserId(), user.getName(), user.getEmail()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/preferences", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, List> allPreferences() {
        return dashboardService.getMovieTypes();
    }
}
