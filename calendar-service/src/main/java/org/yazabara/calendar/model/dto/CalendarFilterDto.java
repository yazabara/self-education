package org.yazabara.calendar.model.dto;

import lombok.Data;

@Data
public class CalendarFilterDto {

    /**
     * By Name calendar filter
     */
    String name;
    /**
     * By Description calendar filter
     */
    String description;
}
