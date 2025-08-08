package com.zengyanyu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 配置跨域
     *
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        /* 是否允许请求带有验证信息 */
        config.setAllowCredentials(true);
        /* 允许访问的客户端域名 */
        config.addAllowedOriginPattern(CorsConfiguration.ALL);
        /* 允许服务端访问的客户端请求头 */
        config.addAllowedHeader(CorsConfiguration.ALL);
        /* 允许访问的方法名,GET POST等 */
        config.addAllowedMethod(CorsConfiguration.ALL);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
