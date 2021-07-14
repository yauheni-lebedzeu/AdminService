package com.gmail.evgeniy.lebedzev.repository.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.gmail.evgeniy.lebedzev.repository")
@EntityScan(basePackages = "com.gmail.evgeniy.lebedzev.repository.model")
public class PersistenceConfig {
}
