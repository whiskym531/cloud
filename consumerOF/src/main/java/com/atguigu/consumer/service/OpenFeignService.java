package com.atguigu.consumer.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2020/12/12
 */
@FeignClient(value = "cloud-payment-service")
public interface OpenFeignService {

    @GetMapping("/payment/find/{id}")
    CommonResult<Payment> findById(@PathVariable(value = "id") Long id); //在Feign里必加这个value值，否则启动报错
}
