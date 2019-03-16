package com.stackroute.productservice.exceptions;

public class ProductAlreadyUpdatedException extends Exception {
    private String message;

    public ProductAlreadyUpdatedException(String message) {

        super(message);
        this.message = message;
    }

    public ProductAlreadyUpdatedException() {

    }

}
