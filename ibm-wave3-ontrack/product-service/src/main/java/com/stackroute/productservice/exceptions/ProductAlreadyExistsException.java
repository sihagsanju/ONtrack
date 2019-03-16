package com.stackroute.productservice.exceptions;

public class ProductAlreadyExistsException extends Exception{
    private String message;

    public ProductAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
    public ProductAlreadyExistsException() {

    }
}
