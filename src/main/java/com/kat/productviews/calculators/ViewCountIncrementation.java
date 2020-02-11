package com.kat.productviews.calculators;

import com.kat.productviews.entity.Product;


public class ViewCountIncrementation {

    private Product product;

    public ViewCountIncrementation(Product product) {
        this.product = product;
    }

    public Product addProductViews (){
        product.getViewCount().addViews();
        return product;
    }

}
