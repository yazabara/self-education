package org.yazabara.common.liquibase.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@RequiredArgsConstructor
public class SchemaCreatorService implements InitializingBean {

    private final LiquibaseProperties liquibaseProperties;
    private final DataSource dataSource;

    @Override
    public void afterPropertiesSet() {
        log.debug("Creation schema process started with configs: {}", liquibaseProperties);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("CREATE SCHEMA IF NOT EXISTS " + liquibaseProperties.getDefaultSchema());
    }
}
