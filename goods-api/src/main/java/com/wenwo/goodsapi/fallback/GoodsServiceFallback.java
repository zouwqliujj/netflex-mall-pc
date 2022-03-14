package com.wenwo.goodsapi.fallback;

import com.wenwo.goodsapi.IGoodsService;

public class GoodsServiceFallback{
    public String getGoodsById() {
        return "查询商品信息异常，Hystrix触发了降级保护机制";
    }

    public String getGoodsById(int id){
        return "查询商品信息异常，Hystrix触发了降级保护机制";
    }
}
