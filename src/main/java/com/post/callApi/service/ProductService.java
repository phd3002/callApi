package com.post.callApi.service;

import com.post.callApi.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product saveProduct(Product p);

    Page<Product> getPaginatedProducts(Pageable pageable);

    Page<Product> searchByName(String keyword, Pageable pageable);

    Page<Product> filterByPriceRange(double min, double max, Pageable pageable);

    Page<Product> searchByNameAndPrice(String keyword, double min, double max, Pageable pageable);

}
