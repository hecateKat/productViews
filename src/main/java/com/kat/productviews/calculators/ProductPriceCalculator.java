package com.kat.productviews.calculators;

import com.kat.productviews.constant.DiscountPercent;
import com.kat.productviews.entity.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductPriceCalculator {

    public static BigDecimal calculateProductPrice(Product product) {
        if (product.isTypeFemale()) {
            return product.getBasePrice().multiply(DiscountPercent.FEMALE_DISCOUNT).setScale(2, RoundingMode.CEILING);

        } else if (product.isTypeMale()) {
            return product.getBasePrice().multiply(DiscountPercent.MALE_DISCOUNT).setScale(2, RoundingMode.CEILING);

        } else {
            return product.getBasePrice().multiply(DiscountPercent.KID_DISCOUNT).setScale(2, RoundingMode.CEILING);
        }
    }
}