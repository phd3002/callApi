package com.post.callApi.repository;

import com.post.callApi.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    boolean existsByName(String name);

    Product findByName(String name);

    @Query("{ 'name': {$regex: ?0, $options: 'i' } }")
    Page<Product> searchByName(String name, Pageable pageable);

    @Query("{ 'price': { $gte: ?0, $lte: ?1 } }")
    Page<Product> filterByPriceRange(double min, double max, Pageable pageable);

    @Query("{ 'name': { $regex: ?0, $options: 'i' }, 'price': { $gte: ?1, $lte: ?2 } }")
    Page<Product> searchByNameAndPriceRange(String keyword, double min, double max, Pageable pageable);
}

