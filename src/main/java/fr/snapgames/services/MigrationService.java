package fr.snapgames.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.flywaydb.core.Flyway;

import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class MigrationService {
    // You can Inject the object if you want to use it manually
    @Inject
    Flyway flyway;

    public void checkMigration() {
        // Use the flyway instance manually
        flyway.clean();

        flyway.migrate();
        // This will print 1.0.0
        log.info("Current Data project version is {}",flyway.info().current().getVersion().toString());
    }
}