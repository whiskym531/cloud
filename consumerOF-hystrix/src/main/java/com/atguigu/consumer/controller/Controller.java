package com.atguigu.consumer.controller;

import com.atguigu.consumer.service.FeignHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2020/12/12
 */
@RestController
@Slf4j
/**
 * //如果方法没有注解特殊定制服务降级方案，那么就默认走这个服务降级
 * 注意：    用了这个@DefaultProperties后，方法别忘了@HystrixCommand注解，
 *              只是不特殊指定@HystrixCommand的fallbackMethod而已
 */
@DefaultProperties(defaultFallback = "defaultHandler")
public class Controller {

    @Resource
    private FeignHystrixService feignHystrixService;

    @GetMapping("/consumer/hyxtrix/ok/{id}")
    public String ok(@RequestBody int id){
        return feignHystrixService.hystirxOk(id);
    }

    @GetMapping("/consumer/hystrix/timeout/{id}")
    /**
     * //服务降级，走handler这个方法。是否降级条件在commandProperties里
     * 一对一的可以用这个
     */
    @HystrixCommand(fallbackMethod = "handler"
            ,commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliSecond",value = "3000")
    })
    public String Timeout(@RequestBody int id){
        return feignHystrixService.hystirxTimeout(id);
    }
    public String handler(){
        return "handler o(╥﹏╥)o";
    }
    public String defaultHandler(){
        return "defaultHandler o(╥﹏╥)o";
    }


    /**
     *       服务熔断
     */
    @HystrixCommand(fallbackMethod = "BreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //窗口期内请求次数， 默认20
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliSeconds",value = "10000"), //时间窗口期， 默认10s
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") //失败率到达多少后跳闸， 默认50%
    })
    public String Breaker(){
        return "Breaker";
    }

    public String BreakerFallback(){
        return "BreakerFallback...";
    }

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(1);

        DecimalFormat decimalFormat = new DecimalFormat("######0.00");
        String format = decimalFormat.format(bigDecimal);
        System.out.println(format);
    }
}
