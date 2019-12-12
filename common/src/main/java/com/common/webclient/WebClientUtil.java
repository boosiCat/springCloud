package com.common.webclient;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * http工具类
 */
@Component
public class WebClientUtil {

    @Resource
    private WebClient client;

    /**
     * get请求,同步返回
     */
    public String get(String url) {
        Mono<String> response = client.get()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .retrieve()
                .bodyToMono(String.class);
        return response.block();
    }

    /**
     * post请求json数据,同步返回
     */
    public String postJson(String url, Object requestBody) {
        Mono<String> response = client.post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .syncBody(requestBody)
                .retrieve()
                .bodyToMono(String.class);
        return response.block();
    }

    /**
     * post请求form数据,同步返回
     */
    public String postForm(String url, MultiValueMap<String, String> multiValueMap) {
        Mono<String> response = client.post()
                .uri(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .syncBody(multiValueMap)
                .retrieve()
                .bodyToMono(String.class);
        return response.block();
    }
}
