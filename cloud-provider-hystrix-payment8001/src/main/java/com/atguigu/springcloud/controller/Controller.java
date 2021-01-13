package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2020/12/12
 */
@RestController
@Slf4j
public class Controller {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private HystrixService hystrixService;

    @GetMapping("/hystrix/ok")
    public String hystirxOk(int id){
        return hystrixService.RESOK(id)+serverPort;
    }
    @GetMapping("/hystrix/timeout")
    public String hystirxTimeout(int id){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hystrixService.Timeout(id)+serverPort;
    }

}
