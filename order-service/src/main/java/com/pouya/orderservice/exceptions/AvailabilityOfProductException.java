package com.pouya.orderservice.exceptions;

public class AvailabilityOfProductException extends IllegalArgumentException {
    public AvailabilityOfProductException() {
        super("The product is not available.");
    }
}
