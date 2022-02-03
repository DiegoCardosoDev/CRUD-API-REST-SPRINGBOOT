package com.example.springwebproject.services.exeptions;

public class ObjectNotFoudExeption extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ObjectNotFoudExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectNotFoudExeption(String message) {
        super(message);
    }
}

