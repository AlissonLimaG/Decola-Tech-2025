package com.padrao.mvc.mvc.configs.check;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class HealthCheck implements HealthIndicator{

    @Override
    public Health health() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'health'");
    }

}
