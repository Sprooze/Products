package com.example.ecomerce.controller;

import com.example.ecomerce.model.Product;
import com.example.ecomerce.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    // Constructor injection
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET маршрут /products
    @GetMapping("/products")
    public String getProducts(Model model) {

        List<Product> products = productService.getAllProducts();

        model.addAttribute("products", products);

        return "products";
    }
}
