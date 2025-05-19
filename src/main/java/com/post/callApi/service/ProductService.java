package com.post.callApi.service;

import com.post.callApi.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product saveProduct(Product p);
}
