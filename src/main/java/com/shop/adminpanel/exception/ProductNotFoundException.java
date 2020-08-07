package com.shop.adminpanel.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id){
        super("This product with id: " +  id  + " does not exist!");
    }
}
