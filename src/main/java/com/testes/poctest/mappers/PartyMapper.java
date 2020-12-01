package com.testes.poctest.mappers;

import com.testes.poctest.dtos.PartyCreateDto;
import com.testes.poctest.dtos.PartyGetDto;
import com.testes.poctest.dtos.PartyUpdateDto;
import com.testes.poctest.entities.PartyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper(uses = {Qualifiers.class})
public abstract class PartyMapper {

    public static final PartyMapper INSTANCE = Mappers.getMapper(PartyMapper.class);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "locale", source = "locale")
    @Mapping(target = "date", source = "date", qualifiedByName = {"Qualifiers", "toDateTimeFromString"})
    public abstract PartyEntity mapFrom(final PartyCreateDto partyCreateDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "locale", source = "locale")
    @Mapping(target = "date", source = "date", qualifiedByName = {"Qualifiers", "toDateTimeFromString"})
    public abstract PartyEntity mapFrom(final PartyUpdateDto partyUpdateDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "locale", source = "locale")
    @Mapping(target = "guestDtos", source = "guestEntities", qualifiedByName = {"Qualifiers", "toListGuestDtoFromListGuestEntity"})
    public abstract PartyGetDto mapFrom(final PartyEntity partyEntity);

    public Page<PartyGetDto> mapFrom(final Page<PartyEntity> partyEntities) {
        return partyEntities.map(this::mapFrom);
    }
}
