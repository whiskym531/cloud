package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2020/12/12
 */
@Service
public class HystrixService {

    public String RESOK(int id){
        return Thread.currentThread().getName()+"OK"+id;
    }

    @HystrixCommand(fallbackMethod = "handler" //服务降级，走handler这个方法。是否降级条件在commandProperties里
            ,commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliSecond",value = "3000")
    })
    public String Timeout(int id){
        return Thread.currentThread().getName()+"timeout"+id;
    }
    public String handler(){
        return "handler o(╥﹏╥)o";
    }
}
