package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2020/12/4
 */
@Slf4j
@Repository
public class PaymentDao {
    public int create(Payment payment){
        log.info("payment8002 paymentDao create ---- payment :{}",payment);
        return 531;
    }

    public Payment findById(Long id){
        log.info("payment8002 paymentDao findById ---- id:{}",id);
        return new Payment(9L,"666");
    }
}
