package com.wenwo.controller;

import com.wenwo.goodsapi.IGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GoodsService implements IGoodsService {

    @Value("${server.port}")
    private String port;

    /**
     * 根据ID查询商品信息
     * @return
     */
    @GetMapping("/goods")
    public String getGoodsById(){
        log.info("收到请求，端口为：{}",port);
        return "返回商品信息";
    }

    @GetMapping("/goods/{id}")
    public String getGoodsById(@PathVariable("id") int id){
        log.info("收到请求，端口为：{}",port);
        if(id%2==0){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "返回商品信息";
    }
}
