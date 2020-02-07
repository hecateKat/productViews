package com.kat.productviews.model;

import com.kat.productviews.constant.DiscountPercent;
import com.kat.productviews.entity.Product;
import com.kat.productviews.enums.Type;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        this.price = calculateProductPrice(product);
        this.type = product.getType();
        this.viewNumber = product.getViewNumber();
    }

    public BigDecimal calculateProductPrice(Product product) {
        if (product.isTypeFemale()) {
            return product.getBasePrice().multiply(DiscountPercent.FEMALE_DISCOUNT).setScale(2, RoundingMode.CEILING);

        } else if (product.isTypeMale()) {
            return product.getBasePrice().multiply(DiscountPercent.MALE_DISCOUNT).setScale(2, RoundingMode.CEILING);

        } else {
            return product.getBasePrice().multiply(DiscountPercent.KID_DISCOUNT).setScale(2, RoundingMode.CEILING);
        }
    }
}