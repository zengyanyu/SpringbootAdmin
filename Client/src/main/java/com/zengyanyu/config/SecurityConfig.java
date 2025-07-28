package com.zengyanyu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // 禁用 CSRF 保护  ,这个一定要设置，都则，日志 日志配置中的日志级别修改会报403权限问题
                .authorizeRequests()
                .antMatchers("/login", "/actuator/**").permitAll()// 不需要进行登录，登录页面放行
                .anyRequest().authenticated();
    }

}
