package org.yazabara.calendar.service.calendar;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.yazabara.calendar.exception.CalendarNotFoundException;
import org.yazabara.calendar.model.data.Calendar;
import org.yazabara.calendar.model.dto.CalendarDto;
import org.yazabara.calendar.model.dto.CalendarFilterDto;
import org.yazabara.calendar.model.mapper.CalendarMapper;
import org.yazabara.calendar.model.specification.CalendarSpecifications;
import org.yazabara.calendar.repository.CalendarRepository;
import org.yazabara.calendar.service.CalendarService;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService {

    private final CalendarRepository repository;
    private final CalendarMapper mapper;

    @Override
    public long create(CalendarDto dto) {
        return repository.save(mapper.toEntity(dto)).getId();
    }

    @Override
    public CalendarDto get(long id) {
        return mapper.toDto(getById(id));
    }

    @Override
    @Transactional
    public void update(long id, CalendarDto dto) {
        Calendar calendar = getById(id);
        mapper.mergeToEntity(dto, calendar);
        // JPA auto save
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<CalendarDto> filter(CalendarFilterDto filter, Pageable pageable) {
        return repository
                .findAll(CalendarSpecifications.byFilter(filter), pageable)
                .map(mapper::toDto);
    }

    private Calendar getById(long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new CalendarNotFoundException(String.format("Calendar with id %s not found", id)));
    }
}
