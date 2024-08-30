package com.example.EventOrganizerBack.controllers.utils;

import lombok.Data;

@Data
public class ResponseWrapper<T> {
    private String message;
    private T data;

    public ResponseWrapper(String message, T data){
        this.message = message;
        this.data = data;
    }
}
