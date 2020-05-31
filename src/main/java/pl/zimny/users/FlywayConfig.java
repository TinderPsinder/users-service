package pl.zimny.users;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {
    protected final static String SCHEMA_VERSION_TABLE = "schema_version";

    @Bean
    protected Flyway createFlyway(DataSource theDataSource) {
        Flyway flyway = Flyway
                .configure()
                .table(SCHEMA_VERSION_TABLE)
                .outOfOrder(true)
                .schemas("users")
                .dataSource(theDataSource)
                .locations(
                        "classpath:db/migration",
                        "classpath:db/insert")
                .load();

        flyway.clean();
        flyway.baseline();
        flyway.migrate();
        return flyway;
    }
}
