package com.stackroute.quizify.signleplayerengine.exception;

public class GamePlayerAlreadyExistsException extends Exception{
    private String message;

    public GamePlayerAlreadyExistsException(String message) {

            super(message);
            this.message = message;
    }
}
