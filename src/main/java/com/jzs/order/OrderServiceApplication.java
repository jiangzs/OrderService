package com.jzs.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;


@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class OrderServiceApplication {

    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }


    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
