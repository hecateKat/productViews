package com.kat.productviews.exceptions;

import java.util.UUID;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException (UUID id) {
        super("No product found with id: " + id);
    }
}