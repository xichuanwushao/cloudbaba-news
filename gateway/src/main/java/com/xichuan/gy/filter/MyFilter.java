package com.xichuan.gy.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/***
 * 只对post请求有用
 */
//@Component
public class MyFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // 判断header中是否有token，对用户请求进行判断过滤

        HttpHeaders headers = exchange.getRequest().getHeaders();
        String utoken = headers.getFirst("utoken");
        String uid = headers.getFirst("uid");

        if (StringUtils.isBlank(utoken) || !utoken.equalsIgnoreCase("abc123")) {
            exchange.getResponse().setStatusCode(HttpStatus.BAD_GATEWAY);
            // 禁止通行，禁止向下继续路由
            return exchange.getResponse().setComplete();
        }

        if (StringUtils.isBlank(uid) || !uid.equalsIgnoreCase("1001")) {
            exchange.getResponse().setStatusCode(HttpStatus.BAD_GATEWAY);
            // 禁止通行，禁止向下继续路由
            return exchange.getResponse().setComplete();
        }

        // 放行
        return chain.filter(exchange);
    }

    // 过滤器的顺序，数字越小优先级越大
    @Override
    public int getOrder() {
        return 0;
    }
}
