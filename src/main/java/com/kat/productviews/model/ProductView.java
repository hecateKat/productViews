package com.kat.productviews.model;

import com.kat.productviews.entity.Product;
import com.kat.productviews.enums.Type;
import com.kat.productviews.calculators.ProductPriceCalculator;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;


@Data
public class ProductView {

    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private Type type;
    private int viewNumber;


    public ProductView(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = ProductPriceCalculator.calculateProductPrice(product);
        this.type = product.getType();
        this.viewNumber = product.getViewCount().getViews();
    }
}