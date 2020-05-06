package org.yazabara.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.yazabara.calendar.model.data.Calendar;

@Repository
public interface CalendarRepository extends JpaSpecificationExecutor<Calendar>, JpaRepository<Calendar, Long> {
}
