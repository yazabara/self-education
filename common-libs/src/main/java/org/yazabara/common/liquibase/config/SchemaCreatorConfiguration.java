package org.yazabara.common.liquibase.config;

import liquibase.integration.spring.SpringLiquibase;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.yazabara.common.liquibase.service.SchemaCreatorService;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(LiquibaseProperties.class)
public class SchemaCreatorConfiguration {

    private final DataSource dataSource;
    private final LiquibaseProperties liquibaseProperties;

    @Bean(name = "liquibase")
    @DependsOn("schemaCreatorService")
    public SpringLiquibase liquibase() {
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setChangeLog(liquibaseProperties.getChangeLog());
        springLiquibase.setDataSource(dataSource);
        springLiquibase.setDefaultSchema(liquibaseProperties.getDefaultSchema());
        springLiquibase.setChangeLogParameters(liquibaseProperties.getParameters());
        springLiquibase.setContexts(liquibaseProperties.getContexts());
        springLiquibase.setLabels(liquibaseProperties.getLabels());
        springLiquibase.setDropFirst(liquibaseProperties.isDropFirst());
        springLiquibase.setRollbackFile(liquibaseProperties.getRollbackFile());
        springLiquibase.setLiquibaseSchema(liquibaseProperties.getLiquibaseSchema());
        springLiquibase.setLiquibaseTablespace(liquibaseProperties.getLiquibaseTablespace());
        springLiquibase.setDatabaseChangeLogTable(liquibaseProperties.getDatabaseChangeLogTable());
        springLiquibase.setDatabaseChangeLogLockTable(liquibaseProperties.getDatabaseChangeLogLockTable());
        return springLiquibase;
    }

    @Bean("schemaCreatorService")
    public SchemaCreatorService schemaCreatorService() {
        return new SchemaCreatorService(liquibaseProperties, dataSource);
    }
}
