package com.post.callApi.repository;

import com.post.callApi.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
    boolean existsByName(String name);

    Product findByName(String name);
}

