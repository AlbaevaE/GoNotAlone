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

    public Boolean getSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(Boolean successful) {
        isSuccessful = successful;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
