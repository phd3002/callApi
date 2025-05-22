package com.post.callApi.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * ExternalProduct Schema:
 * {
 *   "id": "string (tự sinh)",
 *   "product_name": "string",
 *   "product_category": "string",
 *   "product_price": double
 * }
 */
@Getter
@Setter
@Document(collection = "external_products")
public class ExternalProduct {
    @Id
    private String id;

    private String product_name;
    private String product_category;
    private double product_price;
}

