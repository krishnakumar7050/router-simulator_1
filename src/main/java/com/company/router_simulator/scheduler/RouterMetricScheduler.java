package com.company.router_simulator.scheduler;


import com.company.router_simulator.config.SimulatorProperties;

import com.company.router_simulator.model.RouterMetric;

import com.company.router_simulator.service.KafkaProducerService;

import com.company.router_simulator.service.RouterGenerator;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;

import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.stereotype.Component;

@Slf4j

@Component

@RequiredArgsConstructor

public class RouterMetricScheduler {

    private final RouterGenerator generator;

    private final KafkaProducerService producer;

    private final SimulatorProperties properties;

    @Scheduled(fixedRate = 10000)

    public void generateMetrics() {

        for (int i = 1;

             i <= properties.getDeviceCount();

             i++) {

            String deviceId =

                    "router-" + i;

            RouterMetric metric =

                    generator.generateMetric(

                            deviceId

                    );

            producer.publish(metric);

            log.info(

                    "Published {}",

                    metric

            );

        }

    }

}

