package com.post.callApi.repository;

import com.post.callApi.entity.ExternalProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExternalProductRepository extends MongoRepository<ExternalProduct, String> {
}

