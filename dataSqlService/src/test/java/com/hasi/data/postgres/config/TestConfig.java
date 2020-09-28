package com.hasi.data.postgres.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.hasi.data.postgres")
@EntityScan("com.hasi.data.postgres")
@EnableJpaRepositories("com.hasi.data.postgres")
@PropertySource("postgres.properties")
@EnableAutoConfiguration
public class TestConfig {
}
