package com.stackroute.quizify.gamemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GloballyExceptionHandler {

    @ExceptionHandler(NoGamesFoundException.class)
    public ResponseEntity<String> handleNoGamesFoundException(NoGamesFoundException exc)
    {
        return new ResponseEntity<String>("No Games found for given Topic/Genre!", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GameAlreadyExistsException.class)
    public ResponseEntity<String> handleGameAlreadyExistsException(GameAlreadyExistsException exc)
    {
        return new ResponseEntity<String>("Game already exists for given ID!", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(GameNotFoundException.class)
    public ResponseEntity<String> handleGameNotFoundException(GameNotFoundException exc)
    {
        return new ResponseEntity<String>("Game not found for given ID!", HttpStatus.NOT_FOUND);
    }
}
