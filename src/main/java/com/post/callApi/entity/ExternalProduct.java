package com.post.callApi.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "external_products")
public class ExternalProduct {
    @Id
    private String id;

    private String name;
    private String source;
    private double price;

    public ExternalProduct() {}

    public ExternalProduct(String name, String source, double price) {
        this.name = name;
        this.source = source;
        this.price = price;
    }
}

