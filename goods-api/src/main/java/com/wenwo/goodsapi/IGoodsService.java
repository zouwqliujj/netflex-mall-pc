package com.wenwo.goodsapi;

import com.wenwo.goodsapi.fallback.GoodsServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "goods-service",fallback = GoodsServiceFallback.class)
public interface IGoodsService {
    @GetMapping("/goods")
    String getGoodsById();

    @GetMapping("/goods/{id}")
    String getGoodsById(@PathVariable("id") int id);
}
