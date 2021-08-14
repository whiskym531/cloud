package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2020/12/1
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        Boolean result = paymentService.create(payment);
        if (result) {
            System.out.println("create successfully");
            return new CommonResult(200,"S", true);
        }
        return new CommonResult(500,"E");
    }

    @GetMapping(value = "/payment/find/{id}")
    public CommonResult findById(@PathVariable("id") Long id){

        Payment payment = paymentService.findById(id);
        if (payment != null){
//            System.out.println("find by id successfully");
            return new CommonResult(200,"S",payment);
        }
        return new CommonResult(500,"没找到，id="+id);
    }
    @GetMapping("/payment/lb")
    public String getServerPort(){
        return serverPort;
    }

    @RequestMapping(value = "/payment/secKill")
    public CommonResult secKill(@RequestParam("id") Long id){
        log.info("this is 8003 service,sir");
        try {
            Payment payment = paymentService.findById(id);
            if (payment.getStock() > 0){
                Thread.sleep(100);
                paymentService.incrStock(id);
                System.out.println("secKill success");
                return new CommonResult(200,"secKill success---8003");
            }else {
                System.out.println("secKill failed,out of stock...");
                return new CommonResult(200,"secKill failed,out of stock...8003");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("secKill failed,system error...");
            return new CommonResult(200,"secKill failed,system error...8003");
        }
    }
}
