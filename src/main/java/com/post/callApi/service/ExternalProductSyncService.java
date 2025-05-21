package com.post.callApi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExternalProductSyncService {

    private final ExternalProductService externalProductService;

    // Chạy mỗi phút
    @Scheduled(cron = "0 * * * * *")
    public void runSyncJob() {
        externalProductService.syncExternalProducts();
        System.out.println("🔄 Cronjob đã đồng bộ từ external_products -> products");
    }
}
