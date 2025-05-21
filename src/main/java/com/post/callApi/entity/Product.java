package com.post.callApi.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Product Schema:
 * {
 *   "id": "string (tự sinh)",
 *   "name": "string",
 *   "category": "string",
 *   "price": double
 * }
 */

@Document(collection = "products")
@Getter
@Setter
public class Product {
    @Id
    private String id;
    private String name;
    private String category;
    private double price;
}

