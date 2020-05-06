package org.yazabara.calendar.model.specification;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.yazabara.calendar.model.data.Calendar;
import org.yazabara.calendar.model.dto.CalendarFilterDto;

@UtilityClass
public class CalendarSpecifications {

    public Specification<Calendar> byName(String name) {
        return like(name);
    }

    public Specification<Calendar> byDescription(String desc) {
        return like(desc);
    }

    public Specification<Calendar> byFilter(CalendarFilterDto filter) {
        return Specification
                .where(byName(filter.getName()))
                .and(byDescription(filter.getDescription()));
    }

    public Specification<Calendar> like(String str) {
        return StringUtils.isBlank(str) ? null : (root, query, cb) -> cb.like(root.get(Calendar.fields.name), str);
    }
}
