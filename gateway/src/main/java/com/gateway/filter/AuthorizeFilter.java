package com.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {


    private static Set<String> excludeUrls = new HashSet<>();

    private static String[] excludeUrlList = {
            "/core/v2/api-docs",
            "/user/v2/api-docs",
            "/user/login"
    };

    static {
        excludeUrls.addAll(Arrays.asList(excludeUrlList));
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //网关层过滤器
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
