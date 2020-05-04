package org.yazabara.common.liquibase.annotation;

import org.springframework.context.annotation.Import;
import org.yazabara.common.liquibase.config.SchemaCreatorConfiguration;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(SchemaCreatorConfiguration.class)
public @interface SchemaCreatorEnable {
}
