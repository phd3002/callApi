package com.post.callApi.controller;

import com.post.callApi.entity.Product;
import com.post.callApi.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product p) {
        return service.saveProduct(p);
    }
}

