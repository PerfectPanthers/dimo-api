package com.thoughtworks.dimoapi.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
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

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    private Date creationDate = new Date();
    private Map<String, String> userSettings = new HashMap<>();
}
