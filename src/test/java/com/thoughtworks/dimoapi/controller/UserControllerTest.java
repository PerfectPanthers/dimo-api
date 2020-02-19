package com.thoughtworks.dimoapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.dimoapi.entity.User;
import com.thoughtworks.dimoapi.model.LoginRequest;
import com.thoughtworks.dimoapi.service.UserService;
import com.thoughtworks.dimoapi.utils.PasswordUtils;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


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

//    @Test
//    public void testGetAllUsers() throws Exception{
//        when(userService.getAllUsers()).thenReturn(new ArrayList<User>(){
//            {
//               add(new MockUserEntity("Mukesh", "8789789"));
//               add(new MockUserEntity("Arun", "8798784434"));
//            }
//        });
//
//      this.mockMVC.perform(get("/api/users")).andDo(print()).andExpect(status().isOk())
//              .andExpect(jsonPath("$[0].name").value("Mukesh"))
//              .andExpect(jsonPath("$[1].name").value("Arun"));
//
//    }

//    @Test
//    public void testSaveUser() throws Exception{
//        User user = new MockUserEntity("Mukesh","565675");
//        String json = mapper.writeValueAsString(user);
//
//        when(userService.createUser(any(User.class))).thenReturn(user);
//
//        this.mockMVC.perform(
//                    post("/api/user")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json)
//                        .characterEncoding("utf-8"))
//                .andDo(print()).andExpect(status().isOk())
//                .andExpect(jsonPath("$.name").value("Mukesh"));
//
//    }


    @Test
    public void testDoLoginSuccess() throws Exception {
        User murugesan = new User("1", "Murugesan");
        murugesan.setEmail("abc123@gmail.com");
        murugesan.setPassword(PasswordUtils.encrypt("abc"));
        when(userService.findByEmail("abc123@gmail.com")).thenReturn(murugesan);
        LoginRequest loginRequest = new LoginRequest("abc123@gmail.com", "abc");
        String json = mapper.writeValueAsString(loginRequest);

        this.mockMVC.perform(post("/api/login").contentType(MediaType.APPLICATION_JSON)
                .content(json).characterEncoding("utf-8"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.statusCode").value(true))
                .andExpect(jsonPath("$.message").value("Login successfully"));
    }

    @Test
    public void testDoLoginInvalidUser() throws Exception {
        User murugesan = new User("1", "Murugesan");
        murugesan.setEmail("abc@gmail.com");
        murugesan.setPassword(PasswordUtils.encrypt("abc"));
        when(userService.findByEmail("abc@gmail.com")).thenReturn(murugesan);
        LoginRequest loginRequest = new LoginRequest("abc@gmail.com", "def");
        String json = mapper.writeValueAsString(loginRequest);

        this.mockMVC.perform(post("/api/login").contentType(MediaType.APPLICATION_JSON)
                .content(json).characterEncoding("utf-8"))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.statusCode").value(false))
                .andExpect(jsonPath("$.message").value("Invalid user"));
    }

    @Test
    public void testDoLoginUnregisteredUser() throws Exception {

        when(userService.findByEmail("abc@gmail.com")).thenThrow(new RuntimeException("Could not connect to persistent store"));
        LoginRequest loginRequest = new LoginRequest("abc@gmail.com", "def");
        String json = mapper.writeValueAsString(loginRequest);

        this.mockMVC.perform(post("/api/login").contentType(MediaType.APPLICATION_JSON)
                .content(json).characterEncoding("utf-8"))
                .andExpect(status().isForbidden())
                .andExpect(content().string("Exception occurred during user login"));
    }
}