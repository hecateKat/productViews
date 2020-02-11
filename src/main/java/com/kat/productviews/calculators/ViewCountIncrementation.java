package com.kat.productviews.calculators;

import com.kat.productviews.entity.Product;


public class ViewCountIncrementation {

    public static Product addProductViews (Product product){
        product.getViewCount().addViews();
        return product;
    }

}