package com.kat.productviews.implementation;

import com.kat.productviews.entity.Product;
import com.kat.productviews.enums.Type;
import com.kat.productviews.repository.ProductRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

class ViewCountServiceImplTest {

    private ProductRepository productRepository = Mockito.mock(ProductRepository.class);

    @Test
    void shouldReturnTrueIfProductIsNew() {

        //given
        Product product = new Product("quill pen", "goose feather", BigDecimal.valueOf(847425), Type.FEMALE);

        //then
        Assert.assertEquals(product.getViewCount().getViews(), 0);

    }

    @Test
    void shouldReturnFalseIfProductIsNew() {

        //given
        Product product = new Product("quill pen", "goose feather", BigDecimal.valueOf(847425), Type.FEMALE);

        //then
        Assert.assertNotEquals(product.getViewCount().getViews(), 10);

    }


    @Test
    void shouldReturnTrueWhenProductViewEquals10() {

        //given
        Product product = new Product("quill pen", "goose feather", BigDecimal.valueOf(847425), Type.FEMALE);
        productRepository.save(product);
        ViewCountServiceImpl viewCountService = new ViewCountServiceImpl(productRepository);

        //when

        for (int i = 0; i<10; i++){
            viewCountService.addProductViews(product);
        }

        //then
        Assert.assertEquals(product.getViewCount().getViews(), 10);

    }

    @Test
    void shouldReturnFalseWhenProductViewEquals10() {

        //given
        Product product = new Product("quill pen", "goose feather", BigDecimal.valueOf(847425), Type.FEMALE);
        productRepository.save(product);
        ViewCountServiceImpl viewCountService = new ViewCountServiceImpl(productRepository);

        //when

        for (int i = 0; i<11; i++){
            viewCountService.addProductViews(product);
        }

        //then
        Assert.assertNotEquals(product.getViewCount().getViews(), 10);

    }
}