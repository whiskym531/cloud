package com.atguigu.springcloud.service;


import com.atguigu.springcloud.entities.Payment;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2020/12/2
 */
public interface PaymentService {
    Boolean create (Payment payment);

    Payment findById(Long id);

    Boolean incrStock(Long id);
}
