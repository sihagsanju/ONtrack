package com.stackroute.productssearchservice.exception;

public class ProductDoesNotExistsException extends Exception {
    private String message;

    public ProductDoesNotExistsException(){
        super();
    }

    public ProductDoesNotExistsException(String message){
        super(message);
        this.message=message;
    }
}
