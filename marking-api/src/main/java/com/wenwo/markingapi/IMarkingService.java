package com.wenwo.markingapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="marking-service")
public interface IMarkingService {
    @GetMapping("/promotion")
    public String getPromotionById();
}
