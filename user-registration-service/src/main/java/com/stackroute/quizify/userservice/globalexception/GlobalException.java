package com.stackroute.quizify.userservice.globalexception;



import com.stackroute.quizify.userservice.exceptions.UserAlreadyExistException;
import com.stackroute.quizify.userservice.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalException
{
    @ResponseStatus(value = HttpStatus.CONFLICT, reason="User already exists")
    @ExceptionHandler(UserAlreadyExistException.class)
    public void handleUserAlreadyExistsException(UserAlreadyExistException exc1)
    {
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason="User does not exist")
    @ExceptionHandler(UserNotFoundException.class)
    public void handleUserNotFoundException(UserNotFoundException exc2)
    {
    }
}
