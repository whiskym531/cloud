package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2020/12/4
 */
@Repository
public interface PaymentDao {
    int create(Payment payment);

    Payment findById(Long id);
}
