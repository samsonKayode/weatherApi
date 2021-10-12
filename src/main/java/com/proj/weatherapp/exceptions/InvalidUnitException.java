package com.proj.weatherapp.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidUnitException extends RuntimeException{

    public InvalidUnitException(String message, HttpStatus status){
        super(message);
    }
}
