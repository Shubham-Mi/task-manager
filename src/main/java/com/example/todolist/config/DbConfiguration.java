package com.example.todolist.config;

import javax.sql.DataSource;
import lombok.AllArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class DbConfiguration {

  private final DataSource dataSource;

  @Bean
  public Flyway dbFlyway() {
    Flyway flyway = Flyway.configure()
        .dataSource(dataSource)
        .baselineOnMigrate(true)
        .locations("classpath:db/migrations")
        .load();
    flyway.migrate();
    return flyway;
  }
}
