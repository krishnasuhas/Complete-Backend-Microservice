package com.hasi.batch.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.hasi.data.postgres")
@EntityScan("com.hasi.data.postgres")
@EnableJpaRepositories("com.hasi.data.postgres")
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://b1llrvvrdwdpm7x8qqgi-postgresql.services.clever-cloud.com:5432/b1llrvvrdwdpm7x8qqgi?user=usqqigllv7ljlmna1ban&password=N2gTbeJNnqgghCr26T5q");
        return dataSourceBuilder.build();
    }

}
