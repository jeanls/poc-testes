package com.testes.poctest.mappers;

import com.testes.poctest.dtos.GuestCreateDto;
import com.testes.poctest.entities.GuestEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper
public abstract class GuestMapper {

    public static final GuestMapper INSTANCE = Mappers.getMapper(GuestMapper.class);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "entryAt", ignore = true)
    public abstract GuestEntity mapFrom(final GuestCreateDto guestCreateDto);

    @AfterMapping
    protected void afterMapping(final GuestCreateDto guestCreateDto, @MappingTarget GuestEntity guestEntity) {
        guestEntity.setEntryAt(LocalDateTime.now());
    }
}
