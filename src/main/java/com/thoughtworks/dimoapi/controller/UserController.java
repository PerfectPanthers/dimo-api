package com.thoughtworks.dimoapi.controller;

import com.thoughtworks.dimoapi.entity.User;
import com.thoughtworks.dimoapi.model.Login;
import com.thoughtworks.dimoapi.model.Response;
import com.thoughtworks.dimoapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value="/hello")
    public  String sayHello(){
        return  "hello";
    }

    @PostMapping(value = "/signUp")
    public ResponseEntity createUser(@RequestBody User user) {
        try {
            userService.save(user);
            return new ResponseEntity<Response>(new Response("200", "user created successfully"), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("Exception occurred during user creation");
        }

    }

    @PostMapping(value = "login")
    public  ResponseEntity doLogin(@RequestBody  Login credential){

        try {
            User user =  userService.findByEmail(credential.getEmail());
            if(user.getPassword().equals(credential.getPassword())){
                return new ResponseEntity<Response>(new Response("200", "Login successfully"), HttpStatus.OK);
            } else {
                return new ResponseEntity<Response>(new Response("200", "Invalid user"), HttpStatus.OK);
            }
        } catch (Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.FORBIDDEN).body("Exception occurred during user creation");
        }


    }
}
