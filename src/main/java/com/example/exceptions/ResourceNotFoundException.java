package com.example.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message)
    {
        super(message);
    }
    public ResourceNotFoundException()
    {
        super("the details with mentioned are not found here");
    }
}
