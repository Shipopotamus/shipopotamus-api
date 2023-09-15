package com.github.shipopotamus.config;

import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import org.flywaydb.core.Flyway;
import org.jooq.codegen.GenerationTool;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;


class JooqCodeGenerator {

    private static final String DATABASE_NAME = "shipopotamus";
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5555/" + DATABASE_NAME;
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            throw new RuntimeException("Missing migrationScriptsLocation");
        }

        final var db = database();
        final var projectRootDirectory = args[0];

        try {
            db.start();
            runFlywayMigrations(projectRootDirectory);
            GenerationTool.main(new String[]{"src/main/resources/db/migration/admin/jooq-config.xml"});
        } finally {
            db.stop();
        }
    }

    private static PostgreSQLContainer database() {
        final var containerPort = 5432;
        final var localPort = 5555;
        final var dockerImageName = DockerImageName.parse("postgres:12.5-alpine");
        final var container = new PostgreSQLContainer<>(dockerImageName)
                .withDatabaseName(DATABASE_NAME)
                .withUsername(USERNAME)
                .withPassword(PASSWORD)
                .withExposedPorts(containerPort)
                .withCreateContainerCmdModifier(
                        cmd -> cmd.withHostConfig(
                                new HostConfig()
                                        .withPortBindings(
                                                new PortBinding(Ports.Binding.bindPort(localPort), new ExposedPort(containerPort)))
                        )
                );
        return container;
    }

    private static void runFlywayMigrations(String projectDirPath) {
        schemaPreparationMigration(projectDirPath);
        authenticationModuleMigration(projectDirPath);
    }

    private static void schemaPreparationMigration(String projectDirPath) {
        Flyway flyway = Flyway.configure()
                .dataSource(DATABASE_URL, USERNAME, PASSWORD)
                .locations(buildFilesystemPath(projectDirPath, "application", "admin")).load();
        flyway.migrate();
    }

    private static void authenticationModuleMigration(String projectDirPath) {
        Flyway flyway = Flyway.configure()
                .defaultSchema("authentication_schema")
                .dataSource(DATABASE_URL, USERNAME, PASSWORD)
                .locations(buildFilesystemPath(projectDirPath, "authentication", "authentication"))
                .load();
        flyway.migrate();
    }

    private static String buildFilesystemPath(String projectDirPath, String module, String migrationSubdirectory) {
        return "filesystem:" + projectDirPath + "/" + module + "/src/main/resources/db/migration/" + migrationSubdirectory;
    }

}
