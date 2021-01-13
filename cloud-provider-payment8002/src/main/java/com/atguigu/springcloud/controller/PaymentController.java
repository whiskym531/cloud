package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        if (result >= 0) {
            System.out.println("create successfully");
            return new CommonResult(200,"S",result);
        }
        return new CommonResult(500,"E");
    }

    @GetMapping(value = "/payment/find/{id}")
    public CommonResult findById(@PathVariable("id") Long id){

        Payment payment = paymentService.findById(id);
        if (payment != null){
            System.out.println("find by id successfully");
            return new CommonResult(200,"S",payment);
        }
        return new CommonResult(500,"没找到，id="+id);
    }
    @GetMapping("/payment/lb")
    public String getServerPort(){
        return serverPort;
    }
}
