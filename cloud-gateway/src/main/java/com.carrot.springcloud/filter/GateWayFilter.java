package com.carrot.springcloud.filter;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Author: warm
 * Date: 2021/9/9
 * Description:  filter可以有很多配置名可以用的，但是一般都是直接自定义比较好用
 */
@Configuration
@Slf4j
public class GateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        /**
         * 这里写diy的filter代码
         */
        log.info("into filter-----------");
        //getRequest就像拿到了httpRequest
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");//   ?拼接那种参数
        log.info("uname = {}",uname);
        if (Strings.isNullOrEmpty(uname)){
            log.info("用户呢？");
            //跟他说一声吧说不接受你
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();//结束
        }
        return chain.filter(exchange);//这里是ok了，去下一个filter，可能有很多个filter的
    }

    @Override
    public int getOrder() {
        return 0;  //顺序，反正是全局的，一般就是0，第一个嘛
    }
}
