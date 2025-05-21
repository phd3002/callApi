package com.post.callApi.controller;

import com.post.callApi.dto.ProductPageResponse;
import com.post.callApi.entity.Product;
import com.post.callApi.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * GET /api/products/get-all
     * 🔹 Mô tả: Lấy danh sách sản phẩm có phân trang.
     * 🔹 Params:
     *     - page (int): số trang (bắt đầu từ 0)
     *     - size (int): số lượng document mỗi trang
     * 🔹 Trả về: JSON chứa danh sách sản phẩm và thông tin phân trang.
     */
    @GetMapping("/get-all")
    public ProductPageResponse getPaginatedProducts(Pageable pageable) {
        return new ProductPageResponse(productService.getPaginatedProducts(pageable));
    }

    /**
     * POST /api/products/create
     * 🔹 Mô tả: Tạo sản phẩm mới.
     * 🔹 Body:
     * {
     *     "name": "string",
     *     "category": "string",
     *     "price": double
     * }
     * 🔹 Trả về: Thông tin sản phẩm vừa tạo.
     */
    @PostMapping("/create")
    public Product createProduct(@RequestBody Product p) {
        return productService.saveProduct(p);
    }
}


