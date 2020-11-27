package com.testes.poctest.mappers;

import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Named("Qualifiers")
public class Qualifiers {

    @Named("toDateTimeFromString")
    public LocalDateTime toDateTimeFromString(final String value) {
        if (Objects.isNull(value)) {
            return null;
        }

        return LocalDateTime.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
