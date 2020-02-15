package com.kat.productviews.model;

import com.kat.productviews.enums.Type;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductDTO {

    private String name;
    private String description;
    private BigDecimal price;
    private Type type;
    private int viewNumber;

    public ProductDTO() {
    }

    public ProductDTO(String name, String description, BigDecimal price, Type type, int viewNumber) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.viewNumber = viewNumber;
    }
}