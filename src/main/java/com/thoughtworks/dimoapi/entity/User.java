package com.thoughtworks.dimoapi.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
public class User {

    @Id
    private String userId;

    private String name;

    @Indexed(unique = true)
    private String email;

    private String password;

    //private Date creationDate = new Date();
//    private Map<String, String> preferences = new HashMap<>();

}
