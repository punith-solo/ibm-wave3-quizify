package com.stackroute.exceptions;

public class UserNameNotFoundException extends Exception {

    String message;

    public UserNameNotFoundException(String message)
    {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
