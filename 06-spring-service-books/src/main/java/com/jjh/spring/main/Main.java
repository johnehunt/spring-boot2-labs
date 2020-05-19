package com.jjh.spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Bookshop Service");

        // Tell server to look for book-server.properties or
        // book-server.yml
        System.setProperty("spring.config.name", "book-service");

        SpringApplication.run(Main.class, args);
        System.out.println("Setup finished");
    }
}
