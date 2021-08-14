package com.atguigu.springcloud.common;

import com.atguigu.springcloud.entities.Payment;
import common.MyBatisDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2020/12/4
 */
@Slf4j
@Repository
public class PaymentDao extends MyBatisDao<Payment> {
//    public int create(Payment payment){
//        log.info("payment8002 paymentDao create ---- payment :{}",payment);
//        return 531;
//    }

    public Payment findById(Long id){
//        log.info("payment8002 paymentDao findById ---- id:{}",id);
        return getSqlSession().selectOne(sqlId("findById"),id);
    }

    public Boolean incrStock(Long id) {
        return getSqlSession().update(sqlId("incrStock"),id) == 1;
    }
}
