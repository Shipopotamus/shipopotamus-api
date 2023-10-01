package com.github.shipopotamus.authentication.configuration;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FlywayConfiguration {
    private static final String APPLICATION_MIGRATIONS_PATH = "classpath:db/migration/authentication";

    private final AuthenticationDatabaseProperties dbProperties;

    @PostConstruct
    void setup() {
        final var flywayConfiguration = Flyway.configure()
                .dataSource(dbProperties.getJdbcUrl(), dbProperties.getUsername(), dbProperties.getPassword())
                .locations(APPLICATION_MIGRATIONS_PATH)
                .schemas(dbProperties.getSchemaName())
                .load();
        flywayConfiguration.migrate();
    }

}
