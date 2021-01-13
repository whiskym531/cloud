package com.atguigu.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2020/12/12
 */
@SpringBootApplication
@EnableFeignClients
public class FeignHystrixMain {
    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixMain.class,args);
    }
}
