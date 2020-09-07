package com.hasi.data.mongo.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.hasi.data.mongo")
@EnableMongoRepositories("com.hasi.data.mongo.repository")
public class MongoConfiguration {
}
