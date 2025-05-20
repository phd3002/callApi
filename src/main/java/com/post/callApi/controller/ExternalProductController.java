package com.post.callApi.controller;

import com.post.callApi.entity.ExternalProduct;
import com.post.callApi.service.ExternalProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/external-products")
public class ExternalProductController {

    private final ExternalProductService externalProductService;

    public ExternalProductController(ExternalProductService externalProductService) {
        this.externalProductService = externalProductService;
    }

    /**
     * GET /api/external-products
     * 🔹 Mô tả: Lấy toàn bộ sản phẩm đã được đồng bộ từ API ngoài (Dùng cho cron job).
     */
    @GetMapping
    public List<ExternalProduct> getAllExternalProducts() {
        return externalProductService.getAll();
    }
}

