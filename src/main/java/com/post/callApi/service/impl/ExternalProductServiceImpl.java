package com.post.callApi.service.impl;

import com.post.callApi.entity.ExternalProduct;
import com.post.callApi.entity.Product;
import com.post.callApi.repository.ExternalProductRepository;
import com.post.callApi.repository.ProductRepository;
import com.post.callApi.service.ExternalProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExternalProductServiceImpl implements ExternalProductService {

    private final ExternalProductRepository externalRepo;
    private final ProductRepository productRepo;

    public ExternalProductServiceImpl(ExternalProductRepository externalRepo, ProductRepository productRepo) {
        this.externalRepo = externalRepo;
        this.productRepo = productRepo;
    }

    @Override
    public void syncExternalProducts() {
        List<ExternalProduct> externalList = externalRepo.findAll();

        for (ExternalProduct ext : externalList) {
            if (ext.getProduct_name() == null || ext.getProduct_price() <= 0) {
                System.out.println("⚠️ Bỏ qua do thiếu dữ liệu: " + ext);
                continue;
            }

            Product existing = productRepo.findByName(ext.getProduct_name());

            if (existing == null) {
                // Thêm mới
                Product product = new Product();
                product.setName(ext.getProduct_name());
                product.setCategory(ext.getProduct_category());
                product.setPrice(ext.getProduct_price());

                productRepo.save(product);
                System.out.println("🆕 Đã thêm mới: " + product.getName());
            } else {
                // Cập nhật nếu dữ liệu khác
                boolean updated = false;

                if (!existing.getCategory().equals(ext.getProduct_category())) {
                    existing.setCategory(ext.getProduct_category());
                    updated = true;
                }
                if (existing.getPrice() != ext.getProduct_price()) {
                    existing.setPrice(ext.getProduct_price());
                    updated = true;
                }

                if (updated) {
                    productRepo.save(existing);
                    System.out.println("🔁 Đã cập nhật: " + existing.getName());
                } else {
                    System.out.println("✅ Không thay đổi: " + existing.getName());
                }
            }
        }
    }


    @Override
    public List<ExternalProduct> getAll() {
        return externalRepo.findAll();
    }

    @Override
    public ExternalProduct save(ExternalProduct externalProduct) {
        return externalRepo.save(externalProduct);
    }
}


