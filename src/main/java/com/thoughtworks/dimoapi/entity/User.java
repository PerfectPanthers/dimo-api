package com.thoughtworks.dimoapi.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Document(collection = "users")
public class User {

    @Id
    private String userId;
    private String name;
    @Indexed(unique=true)
    private String email;
    private  String password;
    //private Date creationDate = new Date();
//    private Map<String, String> preferences = new HashMap<>();
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Map<String, String> getPreferences() {
//        return preferences;
//    }
//
//    public void setPreferences(Map<String, String> preferences) {
//        this.preferences = preferences;
//    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
