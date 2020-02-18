package com.thoughtworks.dimoapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.dimoapi.entity.User;
import com.thoughtworks.dimoapi.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MockUserEntity extends User{
    MockUserEntity(String name, String id){
        this.setName(name);
        this.setUserId(id);
    }
}

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @Autowired
    MockMvc mockMVC;

    ObjectMapper mapper = new ObjectMapper();


    @InjectMocks
    UserController userController;


    @Before
    public void setUp() throws Exception {
        mockMVC = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testGetAllUsers() throws Exception{
        when(userService.getAllUsers()).thenReturn(new ArrayList<User>(){
            {
               add(new MockUserEntity("Mukesh", "8789789"));
               add(new MockUserEntity("Arun", "8798784434"));
            }
        });

      this.mockMVC.perform(get("/api/users")).andDo(print()).andExpect(status().isOk())
              .andExpect(jsonPath("$[0].name").value("Mukesh"))
              .andExpect(jsonPath("$[1].name").value("Arun"));

    }

    @Test
    public void testSaveUser() throws Exception{
        User user = new MockUserEntity("Mukesh","565675");
        String json = mapper.writeValueAsString(user);

        when(userService.createUser(any(User.class))).thenReturn(user);

        this.mockMVC.perform(
                    post("/api/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .characterEncoding("utf-8"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Mukesh"));

    }
}