package com.proj.weatherapp.exceptions;

import org.springframework.http.HttpStatus;

public class LimitExceededException extends RuntimeException{

    public LimitExceededException(String message, HttpStatus status){
        super(message);
    }
}
