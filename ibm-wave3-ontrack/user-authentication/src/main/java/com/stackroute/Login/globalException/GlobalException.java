package com.stackroute.Login.globalException;

import com.stackroute.Login.exception.UserNotFoundException;
import com.stackroute.Login.exception.UsernameAndPasswordMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class GlobalException
{
    @ResponseStatus(value = HttpStatus.CONFLICT, reason="UserId and password mismatch!!!")
    @ExceptionHandler(UsernameAndPasswordMismatchException.class)
    public void userIdandPasswordMismatchException(UsernameAndPasswordMismatchException exc1)
    {
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason="User does not exist!!!")
    @ExceptionHandler(UserNotFoundException.class)
    public void userNotFoundException(UserNotFoundException exc2)
    {

    }
}
