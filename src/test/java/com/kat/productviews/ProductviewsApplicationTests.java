package com.kat.productviews;

import com.kat.productviews.constant.DiscountPercent;
import com.kat.productviews.entity.Product;
import com.kat.productviews.enums.Type;
import com.kat.productviews.model.ProductView;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class ProductviewsApplicationTests {


    @Test
    void calculateProductPrice() {


        //given
        Product product1 = new Product("pencil", "blue pencil", BigDecimal.valueOf(100), Type.MALE);
        Product product2 = new Product("quill pen", "goose feather", BigDecimal.valueOf(250), Type.FEMALE);
        Product product3 = new Product("crayon", "multicolor crayon", BigDecimal.valueOf(10), Type.KID);

        //when
        ProductView productView1 = new ProductView(product1);
        ProductView productView2 = new ProductView(product2);
        ProductView productView3 = new ProductView(product3);

        BigDecimal priceAfterDiscount1 = productView1.calculateProductPrice(product1);
        BigDecimal priceAfterDiscount2 = productView2.calculateProductPrice(product2);
        BigDecimal priceAfterDiscount3 = productView3.calculateProductPrice(product3);

        //then
        Assert.assertEquals(product1.getBasePrice().multiply(DiscountPercent.MALE_DISCOUNT), priceAfterDiscount1);
        Assert.assertEquals(product2.getBasePrice().multiply(DiscountPercent.FEMALE_DISCOUNT), priceAfterDiscount2);
        Assert.assertEquals(product3.getBasePrice().multiply(DiscountPercent.KID_DISCOUNT), priceAfterDiscount3);


    }
}
