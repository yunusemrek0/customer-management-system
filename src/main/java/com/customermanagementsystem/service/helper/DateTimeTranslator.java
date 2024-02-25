package com.customermanagementsystem.service.helper;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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


    public LocalDateTime parseLocalDateTime(String dateTime ) {

        LocalDate localDate = LocalDate.parse(dateTime.substring(0,10));
        LocalTime localTime = LocalTime.parse(dateTime.substring(11,16));

        return LocalDateTime.of(localDate,localTime);


    }
}
