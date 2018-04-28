package com.training.playgendary.reservation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@Import(AppConfig.class)
@Profile("test")
public class TestConfig {
    private Environment env;

    @Autowired
    public TestConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
        databaseBuilder.setType(EmbeddedDatabaseType.H2);
        databaseBuilder.addScript("/db/dump/testing/tableCreation.sql");
        databaseBuilder.addScript("/db/dump/testing/dataInsertion.sql");
        EmbeddedDatabase database = databaseBuilder.build();

        return database;
    }

    public Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect.h2", env.getProperty("hibernate.dialect.h2"));
        properties.setProperty("hibernate.max_fetch_depth", env.getProperty("hibernate.max_fetch_depth"));
        properties.setProperty("hibernate.jdbc.fetch_size", env.getProperty("hibernate.jdbc.fetch_size"));
        properties.setProperty("hibernate.jdbc.batch_size", env.getProperty("hibernate.jdbc.batch_size"));
        properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));

        return properties;
    }
}
