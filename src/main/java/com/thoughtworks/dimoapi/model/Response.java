package com.thoughtworks.dimoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    private boolean statusCode;
    private String message;
}
