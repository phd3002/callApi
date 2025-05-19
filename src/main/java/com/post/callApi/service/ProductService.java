package com.post.callApi.service;

import com.post.callApi.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product saveProduct(Product p);

    Page<Product> getPaginatedProducts(Pageable pageable);
}
