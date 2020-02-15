package com.kat.productviews.implementation;

import com.kat.productviews.constant.DiscountPercent;
import com.kat.productviews.entity.Product;
import com.kat.productviews.service.PriceCalculatorService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PriceCalculatorServiceImpl implements PriceCalculatorService {

    @Override
    public BigDecimal calculatePrice(Product product) {

        if (product.getBasePrice().compareTo(BigDecimal.valueOf(500)) >= 0 && product.getBasePrice().compareTo(BigDecimal.valueOf(2000)) < 0){
            return product.getBasePrice().multiply(DiscountPercent.DISCOUNT_3_PERCENT);

        }else if (product.getBasePrice().compareTo(BigDecimal.valueOf(2000)) > 0) {
            return product.getBasePrice().multiply(DiscountPercent.DISCOUNT_5_PERCENT);

        }else {
            return product.getBasePrice();
        }
    }
}