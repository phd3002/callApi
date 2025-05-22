package com.post.callApi.controller;

import com.post.callApi.dto.ProductPageResponse;
import com.post.callApi.entity.Product;
import com.post.callApi.service.ProductService;
import org.springframework.data.domain.PageRequest;
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
     * GET /api/products/get-all?page=0&size=2
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
     * GET api/products/search?keyword=phone&page=0&size=2
     * 🔹 Mô tả: Tìm kiếm sản phẩm theo tên có phân trang.
     * 🔹 Params:
     *    - keyword (String): từ khóa tìm kiếm
     *    - page (int): số trang (bắt đầu từ 0)
     *    - size (int): số lượng document mỗi trang
     *    🔹 Trả về: JSON chứa danh sách sản phẩm và thông tin phân trang.
     */
    @GetMapping("/search")
    public ProductPageResponse searchProducts(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return new ProductPageResponse(productService.searchByName(keyword, pageable));
    }

    /**
     * GET api/products/filter?min=1000&max=2000&page=0&size=2
     * 🔹 Mô tả: Lọc sản phẩm theo khoảng giá có phân trang.
     * 🔹 Params:
     *    - min (double): giá tối thiểu
     *    - max (double): giá tối đa
     *    - page (int): số trang (bắt đầu từ 0)
     *    - size (int): số lượng document mỗi trang
     *    🔹 Trả về: JSON chứa danh sách sản phẩm và thông tin phân trang.
     */
    @GetMapping("/filter")
    public ProductPageResponse filterByPrice(
            @RequestParam double min,
            @RequestParam double max,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return new ProductPageResponse(productService.filterByPriceRange(min, max, pageable));
    }

    /**
     * GET api/products/search-advanced?keyword=phone&min=1000&max=2000&page=0&size=2
     * 🔹 Mô tả: Tìm kiếm sản phẩm theo tên và khoảng giá có phân trang.
     * 🔹 Params:
     *    - keyword (String): từ khóa tìm kiếm
     *    - min (double): giá tối thiểu
     *    - max (double): giá tối đa
     *    - page (int): số trang (bắt đầu từ 0)
     *    - size (int): số lượng document mỗi trang
     *    🔹 Trả về: JSON chứa danh sách sản phẩm và thông tin phân trang.
     */
    @GetMapping("/search-advanced")
    public ProductPageResponse searchByNameAndPrice(
            @RequestParam String keyword,
            @RequestParam double min,
            @RequestParam double max,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return new ProductPageResponse(productService.searchByNameAndPrice(keyword, min, max, pageable));
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


