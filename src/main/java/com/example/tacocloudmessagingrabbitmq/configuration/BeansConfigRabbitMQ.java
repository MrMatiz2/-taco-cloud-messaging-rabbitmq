package com.example.tacocloudmessagingrabbitmq.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
    "com.example.tacoclouddomain.kitchen"
})
public class BeansConfigRabbitMQ {
}
