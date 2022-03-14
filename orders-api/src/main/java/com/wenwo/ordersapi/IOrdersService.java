package com.wenwo.ordersapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "orders-service")
public interface IOrdersService {
    @PostMapping("/order")
    String createOrder(@RequestParam String goodsInfo, @RequestParam String pomotionInfo);

    @GetMapping("/orders")
    String hystrxiDemo();
}
