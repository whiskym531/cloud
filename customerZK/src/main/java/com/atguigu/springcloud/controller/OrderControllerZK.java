package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2020/12/8
 */
@RestController
public class OrderControllerZK {

    public static final String INVOKE_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/customer/payment/info")
    public String paymentInfo(){
        String forObject = restTemplate.getForObject(INVOKE_URL + "/zk/check", String.class);
        return forObject;
    }

}
