package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2020/12/2
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        System.out.println("create");
        int i = paymentDao.create(payment);
        return i;
    }

    @Override
    public Payment findById(Long id) {
        System.out.println("findbyid");
        return paymentDao.findById(id);

    }
}
