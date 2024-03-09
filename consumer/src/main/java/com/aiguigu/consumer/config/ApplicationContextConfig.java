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
    /**
     * 1，↓这个是默认LB，不加就会报错，找不到提供者。UnknownHostException；
     * 2，如果要用自定义的LB算法（见OrderController.getService） and package MyLoadBalance,
     *      则需要去掉这个注解，否则会优先使用默认LB，走自定义LB会找不到instance，No instances available
     */
//    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
