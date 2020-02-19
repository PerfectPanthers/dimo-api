package com.thoughtworks.dimoapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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
    private List preferences;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}
