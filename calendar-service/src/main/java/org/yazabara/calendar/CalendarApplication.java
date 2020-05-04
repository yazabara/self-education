package org.yazabara.calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yazabara.common.liquibase.annotation.SchemaCreatorEnable;

@SchemaCreatorEnable
@SpringBootApplication
public class CalendarApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalendarApplication.class, args);
    }
}