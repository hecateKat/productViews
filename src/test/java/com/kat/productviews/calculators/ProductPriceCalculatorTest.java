package com.kat.productviews.calculators;

import com.kat.productviews.constant.DiscountPercent;
import com.kat.productviews.entity.Product;
import com.kat.productviews.enums.Type;
import com.kat.productviews.model.ProductView;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class ProductPriceCalculatorTest {

    @Test
    void shouldReturnTrueWhenCalculatingProductPrice() {

        //given
        Product product1 = new Product("pencil", "blue pencil", BigDecimal.valueOf(875038575), Type.MALE);
        Product product2 = new Product("quill pen", "goose feather", BigDecimal.valueOf(847425), Type.FEMALE);
        Product product3 = new Product("crayon", "multicolor crayon", BigDecimal.valueOf(3.14), Type.KID);

        //when
        BigDecimal calculatedPrice1 = ProductPriceCalculator.calculateProductPrice(product1);
        BigDecimal calculatedPrice2 = ProductPriceCalculator.calculateProductPrice(product2);
        BigDecimal calculatedPrice3 = ProductPriceCalculator.calculateProductPrice(product3);

        //then
        Assert.assertEquals(product1.getBasePrice().multiply(DiscountPercent.MALE_DISCOUNT).setScale(2, RoundingMode.CEILING), calculatedPrice1);
        Assert.assertEquals(product2.getBasePrice().multiply(DiscountPercent.FEMALE_DISCOUNT).setScale(2, RoundingMode.CEILING), calculatedPrice2);
        Assert.assertEquals(product3.getBasePrice().multiply(DiscountPercent.KID_DISCOUNT).setScale(2, RoundingMode.CEILING), calculatedPrice3);
    }
}