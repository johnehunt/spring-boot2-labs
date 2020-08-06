package com.jjh.spring.store;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@ComponentScan(basePackages = {"com.jjh.spring.beans","com.jjh.spring.store"})
public class TestConfig { }
