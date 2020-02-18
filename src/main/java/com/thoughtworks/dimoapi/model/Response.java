package com.thoughtworks.dimoapi.model;

public class Response {
    private  boolean statusCode;
    private  String message;

    public Response(boolean statusCode, String message){
          this.statusCode = statusCode;
          this.message = message;
      }

    public boolean getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(boolean statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
