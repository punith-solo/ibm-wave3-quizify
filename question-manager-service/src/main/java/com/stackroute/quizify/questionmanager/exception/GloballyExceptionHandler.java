package com.stackroute.quizify.questionmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GloballyExceptionHandler {

    @ExceptionHandler(EnoughQuestionsNotFound.class)
    public ResponseEntity<String> handleEnoughQuestionsNotFound(EnoughQuestionsNotFound exc)
    {
        return new ResponseEntity<String>("Enough Question not found according to requirement!", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoQuestionFoundException.class)
    public ResponseEntity<String> handleNoQuestionFoundException(NoQuestionFoundException exc)
    {
        return new ResponseEntity<String>("No Question found for specific Topic/Genre!", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(QuestionAlreadyExistsException.class)
    public ResponseEntity<String> handleQuestionAlreadyExistsException(QuestionAlreadyExistsException exc)
    {
        return new ResponseEntity<String>("Question already exists for given ID!", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(QuestionDoesNotExistException.class)
    public ResponseEntity<String> handleQuestionDoesNotExistException(QuestionDoesNotExistException exc)
    {
        return new ResponseEntity<String>("Question doesn't exist for given ID!", HttpStatus.NOT_FOUND);
    }
}
