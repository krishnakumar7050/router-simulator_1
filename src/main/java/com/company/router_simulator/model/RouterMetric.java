package com.company.router_simulator.model;

import java.time.Instant;

public record RouterMetric(
        String deviceId,
        int temperature,
        long numPackets,
        boolean alive,
        Instant timestamp
) {
}
