package com.testes.poctest.mappers;

import com.testes.poctest.dtos.GuestDto;
import com.testes.poctest.entities.GuestEntity;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Named("Qualifiers")
public class Qualifiers {

    @Named("toDateTimeFromString")
    public LocalDateTime toDateTimeFromString(final String value) {
        if (Objects.isNull(value)) {
            return null;
        }

        return LocalDateTime.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Named("toListGuestDtoFromListGuestEntity")
    public List<GuestDto> toListGuestDtoFromListGuestEntity(final List<GuestEntity> guestEntities) {
        if (Objects.isNull(guestEntities)) {
            return null;
        }

        return guestEntities.stream().map(guestEntity -> {
            final GuestDto guestDto = new GuestDto();
            guestDto.setId(guestEntity.getId());
            guestDto.setEntryAt(guestEntity.getEntryAt());
            guestDto.setName(guestEntity.getName());
            guestDto.setPhone(guestEntity.getPhone());
            return guestDto;
        }).collect(Collectors.toList());
    }
}
