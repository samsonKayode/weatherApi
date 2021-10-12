package com.proj.weatherapp.exceptions;

import org.springframework.http.HttpStatus;

public class ConnectionError extends RuntimeException{

    public ConnectionError(String message, HttpStatus status){
        super(message);
    }
}
