package com.company.router_simulator;

import com.company.router_simulator.config.SimulatorProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties(
        SimulatorProperties.class
)
public class RouterSimulatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                RouterSimulatorApplication.class,
                args
        );
    }
}