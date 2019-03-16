package com.stackroute.productservice.controller;

import com.stackroute.productservice.exceptions.ProductAlreadyExistsException;
import com.stackroute.productservice.exceptions.ProductAlreadyUpdatedException;
import com.stackroute.productservice.exceptions.ProductIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice

public class GlobalExceptionHandler {
    @ResponseStatus(value= HttpStatus.CONFLICT, reason="ProductDTO already exist")
    @ExceptionHandler(ProductAlreadyExistsException.class)
    public void handleTrackAlreadyExistException(ProductAlreadyExistsException e){
        System.out.println("Product already exist");
    }
    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="ProductDTO id not found")
    @ExceptionHandler(ProductIdNotFoundException.class)
    public void handleTrackNotFoundException(ProductIdNotFoundException e){
        System.out.println("Product id not found");
    }
    @ResponseStatus(value= HttpStatus.CONFLICT, reason="ProductDTO already updated")
    @ExceptionHandler(ProductAlreadyUpdatedException.class)
    public void handleTrackAlreadyUdatedException(ProductAlreadyUpdatedException e){
        System.out.println("Product already updated");
    }
}

