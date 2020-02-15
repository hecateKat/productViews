package com.kat.productviews.implementation;

import com.kat.productviews.entity.Product;
import com.kat.productviews.mapper.ProductMapper;
import com.kat.productviews.model.ProductDTO;
import com.kat.productviews.repository.ProductRepository;
import com.kat.productviews.service.ProductService;
import com.kat.productviews.service.ViewCountService;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ViewCountService viewCountService;

    public ProductServiceImpl(ProductRepository productRepository, ViewCountService viewCountService) {
        this.productRepository = productRepository;
        this.viewCountService = viewCountService;
    }

    @Override
    public ProductDTO findById(UUID id) throws Exception {

        if (id == null) {
            throw new Exception("Wrong id");
        }
        Product productById = productRepository.getOne(id);
        viewCountService.addProductViews(productById);
        ProductDTO productDTO = ProductMapper.mapProductToProductDto(productById);
        return productDTO;
    }
}