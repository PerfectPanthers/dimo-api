package com.thoughtworks.dimoapi.controller;

import com.thoughtworks.dimoapi.entity.User;
import com.thoughtworks.dimoapi.model.LoginRequest;
import com.thoughtworks.dimoapi.model.Response;
import com.thoughtworks.dimoapi.service.UserService;
import com.thoughtworks.dimoapi.utils.PasswordUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @Autowired
    MockMvc mockMVC;

    @InjectMocks
    UserController userController;


    @Before
    public void setUp() {
        mockMVC = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testDoLoginSuccess() {
        User murugesan = new User("1", "Murugesan", "abc123@gmail.com");
        murugesan.setPassword(PasswordUtils.encrypt("abc"));
        when(userService.findByEmail("abc123@gmail.com")).thenReturn(murugesan);
        LoginRequest loginRequest = new LoginRequest("abc123@gmail.com", "abc");
        ResponseEntity<Response> response = userController.login(loginRequest);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testDoLoginInvalidUser() {
        User murugesan = new User("1", "Murugesan", "abc@gmail.com");

        murugesan.setPassword(PasswordUtils.encrypt("abc"));
        when(userService.findByEmail("abc@gmail.com")).thenReturn(murugesan);
        LoginRequest loginRequest = new LoginRequest("abc@gmail.com", "def");
        ResponseEntity<Response> response = userController.login(loginRequest);
        assertEquals(response.getStatusCode(), HttpStatus.UNAUTHORIZED);
    }

    @Test
    public void signupWhenUserExist() {
        User person = new User("u123", "user-name", "user-name@mail.in");
        when(userService.findByEmail("user-name@mail.in")).thenReturn(person);
        ResponseEntity<Response> response = userController.createUser(person);
        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void signup() {
        User person = new User("u123", "user-name", "user-name@mail.in");
        when(userService.findByEmail("user-name@mail.in")).thenReturn(null);
        when(userService.save(person)).thenReturn(person);
        ResponseEntity<Response> response = userController.createUser(person);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    public void testDoLoginUnregisteredUser() {

        when(userService.findByEmail("abc@gmail.com")).thenThrow(new RuntimeException("Could not connect to persistent store"));
        LoginRequest loginRequest = new LoginRequest("mailnotsaved@gmail.com", "def");
        ResponseEntity<Response> response = userController.login(loginRequest);
        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
    }


}