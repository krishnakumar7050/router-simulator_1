package com.company.router_simulator.service;


import com.company.router_simulator.model.RouterMetric;

import lombok.RequiredArgsConstructor;

import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Service;

@Service

@RequiredArgsConstructor

public class KafkaProducerService {

    private final KafkaTemplate<String,

            RouterMetric> kafkaTemplate;

    private static final String TOPIC =

            "router-metrics";

    public void publish(

            RouterMetric metric

    ) {

        kafkaTemplate.send(

                TOPIC,

                metric.deviceId(),

                metric

        );

    }

}

