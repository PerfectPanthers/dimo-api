package com.thoughtworks.dimoapi.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Document(collection = "users")
@NoArgsConstructor
@Data
public class User {

    @Id
    private String userId;
    private String name;
  
    @Indexed(unique=true)
    private String email;
    private  String password;
    //private Date creationDate = new Date();
//    private Map<String, String> preferences = new HashMap<>();
    
//
//    public void setPreferences(Map<String, String> preferences) {
//        this.preferences = preferences;
//    }


    private Date creationDate = new Date();
    private Map<String, String> userSettings = new HashMap<>();
}
