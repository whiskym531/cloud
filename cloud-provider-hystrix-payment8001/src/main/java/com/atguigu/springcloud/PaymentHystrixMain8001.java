package com.atguigu.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2020/12/12
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker//开启服务降级
//@EnableHystrixDashboard  图形化监控
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class,args);
    }


    /**
     *此配置是为了服务监控而配置，与服务 容错本身无关，springcloud 升级后的玩
     *ServletRegistrationBean因为springoot的默认路径不是"/hystrix. stream",
     *只要在自己的项目里配置上下面的servlet就可以了
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix. stream" );
        registrationBean.setName( "HystrixMetricsstreamServlet");
        return registrationBean;
    }
}
