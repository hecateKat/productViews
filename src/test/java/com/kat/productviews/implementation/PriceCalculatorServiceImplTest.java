package com.kat.productviews.implementation;

import com.kat.productviews.constant.DiscountPercent;
import com.kat.productviews.entity.Product;
import com.kat.productviews.enums.Type;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.math.RoundingMode;

class PriceCalculatorServiceImplTest {

    @Test
    void shouldReturnTrueWhenCalculatingProductPrice() {

        //given
        Product product1 = new Product("pencil", "blue pencil", BigDecimal.valueOf(2005.00), Type.MALE);
        Product product2 = new Product("quill pen", "goose feather", BigDecimal.valueOf(845.00), Type.FEMALE);
        Product product3 = new Product("crayon", "multicolor crayon", BigDecimal.valueOf(3.14), Type.KID);

        PriceCalculatorServiceImpl priceCalculatorService = new PriceCalculatorServiceImpl();

        //when
        BigDecimal calculatedPrice1 = priceCalculatorService.calculatePrice(product1).setScale(2, RoundingMode.CEILING);
        BigDecimal calculatedPrice2 = priceCalculatorService.calculatePrice(product2).setScale(2, RoundingMode.CEILING);
        BigDecimal calculatedPrice3 = priceCalculatorService.calculatePrice(product3).setScale(2, RoundingMode.CEILING);

        //then
        Assert.assertEquals(product1.getBasePrice().multiply(DiscountPercent.DISCOUNT_5_PERCENT).setScale(2, RoundingMode.CEILING), calculatedPrice1);
        Assert.assertEquals(product2.getBasePrice().multiply(DiscountPercent.DISCOUNT_3_PERCENT).setScale(2, RoundingMode.CEILING), calculatedPrice2);
        Assert.assertEquals(product3.getBasePrice().setScale(2, RoundingMode.CEILING), calculatedPrice3);
    }
}