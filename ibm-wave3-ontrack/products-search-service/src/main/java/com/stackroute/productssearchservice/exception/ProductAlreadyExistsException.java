package com.stackroute.productssearchservice.exception;

public class ProductAlreadyExistsException extends Exception {
    private String message;

    public ProductAlreadyExistsException(){
        super();
    }

    public ProductAlreadyExistsException(String message){
        super(message);
        this.message=message;
    }
}
