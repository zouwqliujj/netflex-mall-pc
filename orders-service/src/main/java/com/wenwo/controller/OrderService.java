package com.wenwo.controller;

import com.wenwo.ordersapi.IOrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderService implements IOrdersService {

    @PostMapping("/order")
    public String createOrder(@RequestParam String goodsInfo, @RequestParam String pomotionInfo){
        log.info("开始创建订单,请求参数,{},{}",goodsInfo,pomotionInfo);
        return "返回创建订单："+goodsInfo+";"+pomotionInfo;
    }

    @GetMapping("/orders")
    public String hystrxiDemo(){
        try {
            //模拟请求超时。
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }
}

