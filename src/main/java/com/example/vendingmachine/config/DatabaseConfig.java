package com.example.vendingmachine.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.vendingmachine.persistence")
@EntityScan(basePackages = "com.example.vendingmachine.model")
@ComponentScan(basePackages = { "com.example.vendingmachine" })
public class DatabaseConfig {
}
