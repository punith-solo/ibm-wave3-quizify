package com.stackroute.searchservice.exception;

public class GenreDoesNotExistsException extends Exception{
    private String message;

    public GenreDoesNotExistsException(){
        super();
    }

    public GenreDoesNotExistsException(String message){
        super(message);
        this.message=message;
    }
}
