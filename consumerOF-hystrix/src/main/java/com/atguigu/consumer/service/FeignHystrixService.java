package com.atguigu.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2020/12/12
 */

/**
 * fallback属性指定统一服务降级走FeignFallbackService里的方法                 ↓这个class,而且这个class要交给spring
 * 用这个功能记得在yml里配置feign: hystrix: enabled: true
 */
@FeignClient(value = "cloud-payment-service-hystrix",fallback = FeignFallbackService.class)
public interface FeignHystrixService {

    @GetMapping("/hystrix/ok")
    String hystirxOk(int id);
    @GetMapping("/hystrix/timeout")
    String hystirxTimeout(int id);

}
