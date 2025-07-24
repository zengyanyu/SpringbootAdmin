package com.zengyanyu.com.zengyanyu.endpoint;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

// 自定义健康指标（HealthIndicator）
@Component
public class CustomHealthIndicator extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        try {
            if (true) {
                builder.up().withDetail("自定义健康指标", "100%");
            } else {
                builder.down();
            }
        } catch (Exception e) {
            builder.down().withException(e);
        }
    }
}
