package com.ecommerce.exceptions;

public class OrderProcessingException extends Exception {
    public OrderProcessingException(String message) {
        super(message);
    }
}