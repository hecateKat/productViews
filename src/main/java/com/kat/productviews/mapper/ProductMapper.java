package com.kat.productviews.mapper;

import com.kat.productviews.entity.Product;
import com.kat.productviews.implementation.PriceCalculatorServiceImpl;
import com.kat.productviews.model.ProductDTO;

import java.math.RoundingMode;


public class ProductMapper {

    public static ProductDTO mapProductToProductDto (Product product) {
        ProductDTO productDTO = new ProductDTO();
        PriceCalculatorServiceImpl priceCalculatorService = new PriceCalculatorServiceImpl();


        if (product.getId() != null){

            productDTO.setName(product.getName());
            productDTO.setDescription(product.getDescription());
            productDTO.setPrice(priceCalculatorService.calculatePrice(product).setScale(2, RoundingMode.CEILING));
            productDTO.setType(product.getType());
            productDTO.setViewNumber(product.getViewCount().getViews());

        }

        return productDTO;
    }

    public static Product mapProductDtoToProduct (Product product, ProductDTO productDTO){

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setBasePrice(productDTO.getPrice());
        product.setType(productDTO.getType());

        return product;
    }
}
