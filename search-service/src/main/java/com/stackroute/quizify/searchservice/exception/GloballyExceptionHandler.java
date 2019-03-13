package com.stackroute.quizify.searchservice.exception;

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

    @ExceptionHandler(GenreAlreadyExistsException.class)
    public ResponseEntity<String> handleGenreAlreadyExistsException(GenreAlreadyExistsException exc)
    {
        return new ResponseEntity<String>("Genre already exists for given ID!", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(GenreDoesNotExistsException.class)
    public ResponseEntity<String> handleGenreDoesNotExistsException(GenreDoesNotExistsException exc)
    {
        return new ResponseEntity<String>("Genre doesn't exist for given ID!", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TopicAlreadyExistsException.class)
    public ResponseEntity<String> handleTopicAlreadyExistsException(TopicAlreadyExistsException exc)
    {
        return new ResponseEntity<String>("Topic already exists for given ID!", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(TopicDoesNotExistsException.class)
    public ResponseEntity<String> handleTopicDoesNotExistsException(TopicDoesNotExistsException exc)
    {
        return new ResponseEntity<String>("Topic doesn't exist for given ID!", HttpStatus.NOT_FOUND);
    }
}
