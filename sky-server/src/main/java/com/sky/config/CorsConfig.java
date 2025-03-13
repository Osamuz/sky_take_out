package com.sky.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
/**
 * Package:com.sky.config
 * Author:zjh
 */
@Configuration
public class CorsConfig {

    /**
     *
     * 解决跨域
     * @return
     *
     */
    @Bean
    public CorsWebFilter corsWebFilter () {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:8081"); // 允许的前端源
        config.addAllowedMethod("*");  // 允许所有 HTTP 方法
        config.addAllowedHeader("*");  // 允许所有请求头
        config.setAllowCredentials(true); // 允许携带凭证（如 Cookie）

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // 对所有路径生效

        return new CorsWebFilter(source);
    }
}
