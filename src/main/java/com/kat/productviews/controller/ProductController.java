package com.kat.productviews.controller;

import com.kat.productviews.model.ProductDTO;
import com.kat.productviews.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // UUID is created in PreloadingProduct. One endpoint left as it was written in the guidelines.

    @GetMapping("/products/{id}")
    ProductDTO getOneProduct (@PathVariable UUID id) throws Exception {
        return productService.findById(id);
    }
}