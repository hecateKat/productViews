package com.kat.productviews.entity;

import com.kat.productviews.enums.Type;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal basePrice;
    @NotNull
    private Type type;

    private int viewNumber = 0;

    public Product() {
    }

    public Product(String name, String description, BigDecimal basePrice, Type type) {
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
        this.type = type;
    }

    public void addViewsNumber(){
        ++viewNumber;
    }

    public boolean isTypeFemale(){
        return this.type.equals(Type.FEMALE);
    }

    public boolean isTypeMale(){
        return this.type.equals(Type.MALE);
    }

    public boolean isTypeKid(){
        return this.type.equals(Type.KID);
    }
}