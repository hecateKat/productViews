package com.kat.productviews.implementation;

import com.kat.productviews.entity.Product;
import com.kat.productviews.repository.ProductRepository;
import com.kat.productviews.service.ViewCountService;
import org.springframework.stereotype.Service;

@Service
public class ViewCountServiceImpl implements ViewCountService {

    private ProductRepository productRepository;

    public ViewCountServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProductViews (Product product){
        product.getViewCount().addViews();
        productRepository.save(product);
        return product;
    }

}