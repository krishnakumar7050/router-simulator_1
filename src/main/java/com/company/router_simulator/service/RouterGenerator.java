package com.company.router_simulator.service;

import com.company.router_simulator.model.RouterMetric;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Random;

@Service
public class RouterGenerator {

    private final Random random = new Random();

    public RouterMetric generateMetric(
            String deviceId
    ) {

        return new RouterMetric(
                deviceId,
                30 + random.nextInt(40),
                random.nextLong(1000, 100000),
                random.nextInt(100) > 5,
                Instant.now()
        );
    }
}
