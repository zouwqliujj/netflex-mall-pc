package com.wenwo.goodsapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "goods-service")
public interface IGoodsService {
    @GetMapping("/goods")
    public String getGoodsById();
}
