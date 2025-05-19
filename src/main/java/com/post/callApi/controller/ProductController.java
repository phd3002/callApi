package com.post.callApi.controller;

import com.post.callApi.dto.ProductPageResponse;
import com.post.callApi.entity.Product;
import com.post.callApi.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    /**
     * GET /api/products
     *
     * 🔹 Mô tả: Lấy danh sách sản phẩm có phân trang.
     * 🔹 Params:
     *     - page (int): số trang (bắt đầu từ 0)
     *     - size (int): số lượng phần tử mỗi trang
     * 🔹 Trả về: JSON chứa danh sách sản phẩm và thông tin phân trang
     */
    @GetMapping
    public ProductPageResponse getPaginatedProducts(Pageable pageable) {
        return new ProductPageResponse(service.getPaginatedProducts(pageable));
    }

    /**
     * POST /api/products
     *
     * 🔹 Mô tả: Tạo sản phẩm mới.
     * 🔹 Body:
     * {
     *     "name": "string",
     *     "category": "string",
     *     "price": number
     * }
     * 🔹 Trả về: Thông tin sản phẩm vừa tạo.
     */
    @PostMapping
    public Product createProduct(@RequestBody Product p) {
        return service.saveProduct(p);
    }
}


