package com.kat.productviews.calculators;

import com.kat.productviews.entity.Product;
import com.kat.productviews.enums.Type;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


class ViewCountIncrementationTest {

    @Test
    void shouldReturnTrueIfProductIsNew() {

        //given
        Product product = new Product("quill pen", "goose feather", BigDecimal.valueOf(847425), Type.FEMALE);

        //then
        Assert.assertEquals(product.getViewCount().getViews(), 0);

    }

    @Test
    void shouldReturnTrueWhenProductViewEquals10() {

        //given
        Product product = new Product("quill pen", "goose feather", BigDecimal.valueOf(847425), Type.FEMALE);

        //when

        for (int i = 0; i<10; i++){
            ViewCountIncrementation.addProductViews(product);
        }

        //then
        Assert.assertEquals(product.getViewCount().getViews(), 10);

    }
}