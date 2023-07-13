package com.github.shipopotamus.authentication.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "authentication.database")
public class AuthenticationDatabaseProperties {
    private String host;
    private int port;
    private String username;
    private String password;
    private String databaseName;
    private String schemaName;

    public String getJdbcUrl() {
        return "jdbc:postgresql://" + host + ":" + port + "/" + databaseName;
    }

}
