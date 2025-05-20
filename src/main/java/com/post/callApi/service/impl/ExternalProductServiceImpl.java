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
            if (!productRepo.existsByName(ext.getProduct_name())) {
                // Nếu chưa có → thêm mới
                Product product = new Product();
                product.setName(ext.getProduct_name());
                product.setCategory(ext.getProduct_category());
                product.setPrice(ext.getProduct_price());
                productRepo.save(product);
                System.out.println("🆕 Thêm mới: " + product.getName());
            } else {
                Product existing = productRepo.findByName(ext.getProduct_name());
                existing.setCategory(ext.getProduct_category());
                existing.setPrice(ext.getProduct_price());
                productRepo.save(existing);
                System.out.println("🔁 Cập nhật: " + existing.getName());
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


