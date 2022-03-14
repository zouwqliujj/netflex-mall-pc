package com.wenwo.goodsapi.config;

import com.wenwo.goodsapi.fallback.GoodsServiceFallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HystrixFallbackConfiguration {
    @Bean
    public GoodsServiceFallback goodsServiceFallback(){
        return new GoodsServiceFallback();
    }
}
