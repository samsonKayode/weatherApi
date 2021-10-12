package com.proj.weatherapp.exceptions;

import org.springframework.http.HttpStatus;

public class InternalError extends RuntimeException{

    public InternalError(String message, HttpStatus status){
        super(message);
    }
}
