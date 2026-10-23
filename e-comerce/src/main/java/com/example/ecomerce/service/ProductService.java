package com.example.ecomerce.service;

import com.example.ecomerce.model.Product;
import com.example.ecomerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // Constructor injection
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Извличане на всички продукти
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Извличане на продукт по ID
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Добавяне на продукт
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // Обновяване на продукт
    public Product updateProduct(Long id, Product product) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setName(product.getName());
                    existingProduct.setPrice(product.getPrice());
                    existingProduct.setStock(product.getStock());

                    return productRepository.save(existingProduct);
                })
                .orElse(null);
    }

    // Изтриване на продукт
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
