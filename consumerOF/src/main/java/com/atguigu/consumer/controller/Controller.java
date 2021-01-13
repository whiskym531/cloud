package com.atguigu.consumer.controller;

import com.atguigu.consumer.service.OpenFeignService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2020/12/12
 */
@RestController
@Slf4j
public class Controller {
    @Resource
    private OpenFeignService openFeignService;

    @GetMapping("/consumer/payment/find/{id}")
    public CommonResult<Payment> findById(@PathVariable Long id){
        return openFeignService.findById(id);
    }


}
