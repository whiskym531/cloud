package com.aiguigu.consumer.MyLoadBalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2020/12/10
 */
public interface loadBalance {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
