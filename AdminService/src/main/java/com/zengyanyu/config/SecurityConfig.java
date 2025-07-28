package com.zengyanyu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/assets/**", "/actuator/**", "/login", "/instances/**").permitAll()// 不需要认证的地址
                .anyRequest().authenticated().and().formLogin()
                .loginPage("/login")
                .and().logout()
                .logoutUrl("/logout")
                .and().httpBasic()
                .and().csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .ignoringAntMatchers("/instances").disable();
    }

}
