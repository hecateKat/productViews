package com.kat.productviews.service;

import com.kat.productviews.entity.Product;
import java.math.BigDecimal;

public interface PriceCalculatorService {

    BigDecimal calculatePrice(Product product);
}