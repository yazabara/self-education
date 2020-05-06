package org.yazabara.calendar.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.yazabara.calendar.model.dto.CalendarDto;
import org.yazabara.calendar.model.dto.CalendarFilterDto;

public interface CalendarService {

    /**
     * Creates new calendar
     *
     * @param dto calendar to create
     * @return created calendar unique id
     */
    long create(CalendarDto dto);

    /**
     * Returns calendar data by id
     *
     * @param id unique id
     * @return calendar data of throws exception
     */
    CalendarDto get(long id);

    /**
     * Updates calendar by id
     *
     * @param id  unique id
     * @param dto data to update
     */
    void update(long id, CalendarDto dto);

    /**
     * Deletes calendar by id
     *
     * @param id unique id
     */
    void delete(long id);

    /**
     * Returns filtered calendar data page
     *
     * @param filter   custom filter
     * @param pageable page data
     * @return calendars
     */
    Page<CalendarDto> filter(CalendarFilterDto filter, Pageable pageable);
}
