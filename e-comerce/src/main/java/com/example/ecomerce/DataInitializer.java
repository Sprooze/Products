package com.example.ecomerce;

import com.example.ecomerce.model.Product;
import com.example.ecomerce.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DataInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {

        productRepository.save(new Product("Laptop", 1500.00, 10));
        productRepository.save(new Product("Mouse", 25.50, 50));
        productRepository.save(new Product("Keyboard", 45.00, 30));
        productRepository.save(new Product("Monitor", 300.00, 15));
        productRepository.save(new Product("Headphones", 80.00, 20));

        System.out.println("Products added successfully!");
    }
}
