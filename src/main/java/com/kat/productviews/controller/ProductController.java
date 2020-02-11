package com.kat.productviews.controller;

import com.kat.productviews.calculators.ViewCountIncrementation;
import com.kat.productviews.entity.Product;
import com.kat.productviews.exceptions.ProductNotFoundException;
import com.kat.productviews.model.ProductView;
import com.kat.productviews.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

   @GetMapping("/products")
    List<ProductView> getAllProductsViews(){
       List<ProductView> allProductViews = new ArrayList<>();
       productRepository.findAll().forEach(product -> allProductViews.add(new ProductView(product)));

        return allProductViews;
    }

    @PostMapping("/products")
    Product addNewProduct (@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping("/products/{id}")
    ProductView getOneProduct (@PathVariable UUID id){


        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        productRepository.save(ViewCountIncrementation.addProductViews(product));
        return new ProductView(product);
    }

    @PutMapping("/products/{id}")
    Product replaceProduct (@RequestBody Product newProduct, @PathVariable UUID id) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setDescription(newProduct.getDescription());
                    product.setBasePrice(newProduct.getBasePrice());
                    product.setType(newProduct.getType());
                    return productRepository.save(product);
        })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return productRepository.save(newProduct);
                });
    }

    @DeleteMapping("/products/{id}")
    void deleteProduct (@PathVariable UUID id) {
        productRepository.deleteById(id);
    }
}