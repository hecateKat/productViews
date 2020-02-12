package com.kat.productviews.controller;

import com.kat.productviews.calculators.ViewCountIncrementation;
import com.kat.productviews.entity.Product;
import com.kat.productviews.exceptions.ProductNotFoundException;
import com.kat.productviews.model.ProductView;
import com.kat.productviews.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // UUID is created in PreloadingProduct. One endpoint left as it was written in the guidelines.

    @GetMapping("/products/{id}")
    ProductView getOneProduct (@PathVariable UUID id){


        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        productRepository.save(ViewCountIncrementation.addProductViews(product));
        return new ProductView(product);
    }
}