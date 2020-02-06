package com.kat.productviews.databasetest;

import com.kat.productviews.entity.Product;
import com.kat.productviews.enums.Type;
import com.kat.productviews.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) {
        return args -> {
            log.info("Preloading" + productRepository.save(new Product("Watch", "Simple watch", BigDecimal.valueOf(133.53), Type.MALE)));
            log.info("Preloading" + productRepository.save(new Product("Watch", "Black watch", BigDecimal.valueOf(155.45), Type.FEMALE)));
            log.info("Preloading" + productRepository.save(new Product("Watch", "Unicorn watch", BigDecimal.valueOf(125.50), Type.KID)));

        };
    }
}