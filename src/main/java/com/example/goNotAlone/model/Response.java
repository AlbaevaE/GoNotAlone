package com.example.goNotAlone.model;

public class Response {
    Boolean isSuccessful;
    String description;
    Object object;

    public Response(Boolean isSuccessful, String description, Object object) {
        this.isSuccessful = isSuccessful;
        this.description = description;
        this.object = object;
    }
}
