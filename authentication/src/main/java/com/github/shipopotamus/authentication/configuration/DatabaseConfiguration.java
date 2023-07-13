package com.github.shipopotamus.authentication.configuration;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration {

    @Bean
    public DataSource getDataSource(AuthenticationDatabaseProperties properties) {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url(properties.getJdbcUrl())
                .username(properties.getUsername())
                .password(properties.getPassword())
                .build();
    }

}
