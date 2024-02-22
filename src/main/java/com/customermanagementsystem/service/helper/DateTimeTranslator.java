package com.customermanagementsystem.service.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTimeTranslator {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private DateTimeTranslator() {}


    private String formatLocalDateTime(LocalDateTime localDateTime) {
        return localDateTime.format(FORMATTER);
    }

    public LocalDateTime parseLocalDateTime( ) {
        return LocalDateTime.parse(formatLocalDateTime(LocalDateTime.now()), FORMATTER);
    }
}
