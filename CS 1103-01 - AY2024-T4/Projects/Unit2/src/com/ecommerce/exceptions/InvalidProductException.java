package com.ecommerce.exceptions;

public class InvalidProductException extends IllegalArgumentException {
    public InvalidProductException(String message) {
        super(message);
    }
}