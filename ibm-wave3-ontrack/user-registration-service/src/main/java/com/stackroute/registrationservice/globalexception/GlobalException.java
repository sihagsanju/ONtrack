package com.stackroute.registrationservice.globalexception;

import com.stackroute.registrationservice.exceptions.UserAlreadyExistsException;
import com.stackroute.registrationservice.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalException
{
    @ResponseStatus(value = HttpStatus.CONFLICT, reason="User already exists")
    @ExceptionHandler(UserAlreadyExistsException.class)
    public void handleSongAlreadyExistsException(UserAlreadyExistsException exc1)
    {
        //log.error("Song already exists");
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason="User does not exist")
    @ExceptionHandler(UserNotFoundException.class)
    public void handleSongNotFoundException(UserNotFoundException exc2)
    {
        //log.error("User does not exist");
    }
}
