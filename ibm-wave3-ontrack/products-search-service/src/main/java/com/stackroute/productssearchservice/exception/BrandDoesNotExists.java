package com.stackroute.productssearchservice.exception;

public class BrandDoesNotExists extends Exception {
    private String message;

    public BrandDoesNotExists(){
        super();
    }

    public BrandDoesNotExists(String message){
        super(message);
        this.message=message;
    }
}
