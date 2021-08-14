package com.aiguigu.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2020/12/4
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced    //这个不加就会报错，找不到提供者。UnknownHostException
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
