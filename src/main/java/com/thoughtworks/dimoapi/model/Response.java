package com.thoughtworks.dimoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {

    private String userId;
    private String name;
    private String email;


}
