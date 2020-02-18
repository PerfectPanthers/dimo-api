package com.thoughtworks.dimoapi.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

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

    public User(String id, String name){
        this.userId = id;
        this.name = name;
    }
    //private Date creationDate = new Date();
//    private Map<String, String> preferences = new HashMap<>();
    
//
//    public void setPreferences(Map<String, String> preferences) {
//        this.preferences = preferences;
//    }


    private Date creationDate = new Date();
    private Map<String, String> userSettings = new HashMap<>();

}
