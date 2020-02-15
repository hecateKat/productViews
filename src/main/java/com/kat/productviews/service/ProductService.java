package com.kat.productviews.service;

import com.kat.productviews.model.ProductDTO;

import java.util.UUID;

public interface ProductService {

    ProductDTO findById(UUID id) throws Exception;

}
