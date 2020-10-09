package com.jjh.spring.store;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.jjh.spring.beans",
        "com.jjh.spring.store"})
public class TestConfig { }
