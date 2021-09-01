package com.carrot.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2021/9/1
 * Description:
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator routes(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        return routes.route("path_route_bean",
                o -> o.path("/guonei")
                        .uri("http://news.baidu.com")).build(); //uri这里只会到域名过，解析一下host，
                                                            //如果后面跟上/什么什么的是不会管的
                                                        //比如uri写成http://news.baidu.com/asd4f6awef也是可以正常访问
//        return routes;
    }
}
