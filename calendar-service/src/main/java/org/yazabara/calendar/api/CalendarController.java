package org.yazabara.calendar.api;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.yazabara.calendar.model.dto.CalendarDto;
import org.yazabara.calendar.model.dto.CalendarFilterDto;
import org.yazabara.calendar.service.CalendarService;

import javax.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/calendars")
public class CalendarController {

    private final CalendarService calendarService;

    @PostMapping
    public long create(@Valid @RequestBody CalendarDto dto) {
        return calendarService.create(dto);
    }

    @GetMapping
    public Page<CalendarDto> filter(CalendarFilterDto filter, Pageable pageable) {
        return calendarService.filter(filter, pageable);
    }

    @GetMapping("/{id}")
    public CalendarDto get(@PathVariable("id") long id) {
        return calendarService.get(id);
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable("id") long id,
            @Valid @RequestBody CalendarDto dto
    ) {
        calendarService.update(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id) {
        calendarService.delete(id);
    }
}
