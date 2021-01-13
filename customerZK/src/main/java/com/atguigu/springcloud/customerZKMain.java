package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2020/12/8
 */
@SpringBootApplication
@EnableDiscoveryClient
public class customerZKMain {
    public static void main(String[] args) {
        SpringApplication.run(customerZKMain.class,args);
    }
}
