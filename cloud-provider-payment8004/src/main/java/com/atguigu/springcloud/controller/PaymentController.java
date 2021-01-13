package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2020/12/1
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;
    @RequestMapping("/zk/check")
    public void zk(){
        System.out.println(UUID.randomUUID()+serverPort);
    }
}
