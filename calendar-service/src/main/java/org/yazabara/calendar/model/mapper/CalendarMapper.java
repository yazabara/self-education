package org.yazabara.calendar.model.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.yazabara.calendar.model.data.Calendar;
import org.yazabara.calendar.model.dto.CalendarDto;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface CalendarMapper {

    CalendarDto toDto(Calendar calendar);

    Calendar toEntity(CalendarDto calendar);

    void mergeToEntity(CalendarDto dto, @MappingTarget Calendar calendar);
}
