package com.thoughtworks.dimoapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
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

    @Indexed(unique = true)
    private String email;
    private String password;

    public User(String id, String name) {
        this.userId = id;
        this.name = name;
    }

    private Date creationDate = new Date();
    private Map<String, String> userSettings = new HashMap<>();
}
