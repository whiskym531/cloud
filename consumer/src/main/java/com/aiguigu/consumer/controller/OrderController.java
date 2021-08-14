package com.aiguigu.consumer.controller;

import com.aiguigu.consumer.MyLoadBalance.LBan;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2020/12/4
 */
@RestController
@Slf4j
public class OrderController {

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LBan lBan;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create (Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,CommonResult.class);
    }

    @GetMapping("consumer/payment/find/{id}")
    public CommonResult<Payment> findById(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/find/"+id,CommonResult.class);

    }
    @RequestMapping(value = "/payment/secKill")
    public CommonResult secKill(@RequestParam("id") Long id){
        CommonResult forObject = restTemplate.getForObject(PAYMENT_URL + "/payment/secKill?id=" + id, CommonResult.class);
        if (forObject.getMessage().contains("8003")){
            System.out.println("8003");
        }
        return forObject;
    }
    @GetMapping("/consumer/getlb")
    public String getService(){

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        if (instances == null || instances.size() == 0){
            return null;
        }

        ServiceInstance serviceInstance = lBan.instance(instances);
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
}
