package com.post.callApi.service.impl;

import com.post.callApi.entity.Product;
import com.post.callApi.repository.ProductRepository;
import com.post.callApi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    final private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product p) {
        return productRepository.save(p);
    }

    @Override
    public Page<Product> getPaginatedProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> searchByName(String keyword, Pageable pageable) {
        return productRepository.searchByName(keyword, pageable);
    }

    @Override
    public Page<Product> filterByPriceRange(double min, double max, Pageable pageable) {
        return productRepository.filterByPriceRange(min, max, pageable);
    }

    @Override
    public Page<Product> searchByNameAndPrice(String keyword, double min, double max, Pageable pageable) {
        return productRepository.searchByNameAndPriceRange(keyword, min, max, pageable);
    }

}
