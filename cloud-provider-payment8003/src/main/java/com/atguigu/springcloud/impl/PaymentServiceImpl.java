package com.atguigu.springcloud.impl;

import com.atguigu.springcloud.common.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2020/12/2
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;
    @Override
    public Boolean create(Payment payment) {
        System.out.println("create");
        Boolean i = paymentDao.create(payment);
        return i;
    }

    @Override
    public Boolean incrStock(Long id) {
        return paymentDao.incrStock(id);
    }

    @Override
    public Payment findById(Long id) {
//        System.out.println("findbyid");
        return paymentDao.findById(id);

    }
}
