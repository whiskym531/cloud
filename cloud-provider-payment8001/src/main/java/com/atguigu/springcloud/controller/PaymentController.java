package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2020/12/1
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        if (result >= 0) {
            System.out.println("create successfully port:"+serverPort);
            return new CommonResult(200,"S",result);
        }
        return new CommonResult(500,"E");
    }

    @GetMapping(value = "/payment/find/{id}")
    public CommonResult findById(@PathVariable("id") Long id){

        Payment payment = paymentService.findById(id);
        if (payment != null){
            System.out.println("find by id successfully port:"+serverPort);
            return new CommonResult(200,"S",payment);
        }
        return new CommonResult(500,"没找到，id="+id);
    }
    @GetMapping(value = "/payment/discovery")
    public void discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost()+instance.getServiceId()+instance.getPort()+instance.getUri());
        }
    }

    @GetMapping("/payment/lb")
    public String getServerPort(){
        return serverPort;
    }

}
