package com.post.callApi.dto;

import com.post.callApi.entity.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class ProductPageResponse {
    private List<Product> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;

    // Constructor
    public ProductPageResponse(Page<Product> pageData) {
        this.content = pageData.getContent();
        this.page = pageData.getNumber();
        this.size = pageData.getSize();
        this.totalElements = pageData.getTotalElements();
        this.totalPages = pageData.getTotalPages();
    }

    // Getters
}

