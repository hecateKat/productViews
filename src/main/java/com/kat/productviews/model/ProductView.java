package com.kat.productviews.model;

import com.kat.productviews.constant.DiscountPercent;
import com.kat.productviews.entity.Product;
import com.kat.productviews.enums.Type;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Data
public class ProductView {

    private Long id;
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
            BigDecimal femaleDiscount = new BigDecimal(DiscountPercent.femaleDiscount);
            return product.getBasePrice().multiply(femaleDiscount).setScale(2, RoundingMode.CEILING);

        } else if (product.isTypeMale()) {
            BigDecimal maleDiscount = new BigDecimal(DiscountPercent.maleDiscount);
            return product.getBasePrice().multiply(maleDiscount).setScale(2, RoundingMode.CEILING);

        } else {
            BigDecimal kidDiscount = new BigDecimal(DiscountPercent.kidDiscount);
            return product.getBasePrice().multiply(kidDiscount).setScale(2, RoundingMode.CEILING);
        }
    }
}