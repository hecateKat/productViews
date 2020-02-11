package com.kat.productviews.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ViewCount {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    private Product product;
    
    private int views = 0;

    public ViewCount() {
    }

    public ViewCount(Product product, int views) {
        this.product = product;
        this.views = views;
    }

    public void addViews (){
        ++this.views;
    }
}