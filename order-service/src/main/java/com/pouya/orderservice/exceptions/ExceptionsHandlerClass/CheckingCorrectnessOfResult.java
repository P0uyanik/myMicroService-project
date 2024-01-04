package com.pouya.orderservice.exceptions.ExceptionsHandlerClass;

import com.pouya.orderservice.exceptions.AvailabilityOfProductException;

public class CheckingCorrectnessOfResult {
    public static void availabilityOfProduct(Boolean result) {
        if (!result) {
            throw new AvailabilityOfProductException();
        }
    }
}
