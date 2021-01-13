package com.atguigu.consumer.service;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2020/12/15
 */

public class FeignFallbackService implements FeignHystrixService{
    @Override
    public String hystirxOk(int id) {
        return "fallback service ,hystirxOk";
    }

    @Override
    public String hystirxTimeout(int id) {
        return "fallback service ,hystirxTimeout";
    }
}
