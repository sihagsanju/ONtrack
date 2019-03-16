package com.stackroute.productservice.exceptions;

public class ProductIdNotFoundException extends Exception{
    private String message;

    public ProductIdNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public ProductIdNotFoundException() {

    }
}

