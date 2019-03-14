package com.stackroute.quizify.userregistrationservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GloballyExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException e){
        return new ResponseEntity<String>("No User found !", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<?> handleUserAlreadyExistsException(UserAlreadyExistException e){
        return new ResponseEntity<String>("User Already Exists !", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNameExistException.class)
    public ResponseEntity<?> handleUserNameExistsException(UserNameExistException e){
        return new ResponseEntity<String>("User Name Already Exists !", HttpStatus.CONFLICT);
    }

}
