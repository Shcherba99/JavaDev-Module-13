package com.goit.pshcherba.conf;

import org.flywaydb.core.Flyway;


/**
 * This class is responsible for performing database migrations using Flyway.
 * It connects to the H2 database and applies any pending migrations from the specified location.
 * The migrations are applied to the "space_travel" database.
 * <p>
 * It also supports cleaning the database before applying migrations.
 */
public class DatabaseMigration {
    /**
     * The main method that configures and runs Flyway migrations.
     * It initializes a Flyway instance with the necessary database connection details, migration location,
     * and the ability to clean the database before applying the migrations.
     * <p>
     * The steps are as follows:
     * 1. Configure the Flyway instance with a data source, migration locations, and other settings.
     * 2. Perform the database cleaning operation (drop all objects).
     * 3. Apply all pending migrations from the specified location.
     *
     * @param args the command line arguments (not used in this method).
     */
    public static void main(String[] args) {
        // Configure Flyway
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:./data/space_travel", "sa", "")
                .locations("classpath:/db/migration")
                .cleanDisabled(false)
                .load();

        // Clean the database before applying migrations
        flyway.clean();

        // Apply pending migrations
        flyway.migrate();
    }
}
