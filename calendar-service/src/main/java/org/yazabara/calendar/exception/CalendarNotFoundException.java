package org.yazabara.calendar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Calendar not found")
public class CalendarNotFoundException extends CalendarException {

    public CalendarNotFoundException(String message) {
        super(message);
    }
}
