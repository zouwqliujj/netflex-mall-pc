package com.wenwo.controller;



import com.wenwo.goodsapi.IGoodsService;
import com.wenwo.markingapi.IMarkingService;
import com.wenwo.ordersapi.IOrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class GoodsController {

    /*@Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadbalancerClient;

  *//*  @Value("${goodsService.serverList}.split(',')")
    private List<String> goodsList;*//*

   *//* private String getGoodsServer(){
        String serverList="http://localhost:9090/goods,http://localhost:9093/goods";
        String servers[]=serverList.split(",");
        Random random=new Random();
        return servers[random.nextInt(servers.length)];
    }*//*

    @GetMapping("/GoodsAndOrder")
    public String order(){
        log.info("begin do order");
       *//* ServiceInstance si=loadbalancerClient.choose("goods-service");
        String url=String.format("http://%s:%s",si.getHost(),si.getPort());
        log.info("ribbon-url:{}",url);*//*
        String url="http://goods-service/goods";
        String goodsInfo=restTemplate.getForObject(url,String.class);
        String promotionInfo=restTemplate.getForObject("http://marking-service/promotion",String.class);
        MultiValueMap<String,Object> param=new LinkedMultiValueMap<>();
        param.add("goodsInfo",goodsInfo);
        param.add("pomotionInfo",promotionInfo);

        HttpEntity<MultiValueMap<String,Object>> httpEntity=new HttpEntity<>(param,new HttpHeaders());
        ResponseEntity<String> response=restTemplate.postForEntity("http://orders-service/order",httpEntity,String.class);
        return response.getBody();
    }*/

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private IMarkingService markingService; //instance?  Proxy$

    @Autowired
    private IOrdersService ordersService;

    @GetMapping("/GoodsAndOrder")
    public String order(){
        log.info("begin do order");
        String goods=goodsService.getGoodsById();
        String promotion=markingService.getPromotionById();
        String result = ordersService.createOrder(goods, promotion);

        return result;
    }
}
