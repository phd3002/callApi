package com.post.callApi.service;

import com.post.callApi.entity.ExternalProduct;

import java.util.List;

public interface ExternalProductService {
    void syncExternalProducts();

    List<ExternalProduct> getAll();
}

