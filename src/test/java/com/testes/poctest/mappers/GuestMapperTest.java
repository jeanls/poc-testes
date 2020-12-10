package com.testes.poctest.mappers;

import com.testes.poctest.dtos.GuestCreateDto;
import com.testes.poctest.entities.GuestEntity;
import com.testes.poctest.entities.PartyEntity;
import org.junit.Test;

import static org.junit.Assert.*;

public class GuestMapperTest {
    private final GuestMapper mapper = GuestMapper.INSTANCE;

    @Test
    public void toEntityFromDtoTest() {
        GuestCreateDto dto = new GuestCreateDto();
        dto.setName("Jean");
        dto.setPartyId(1);
        dto.setPhone("(11) 95433-2222");

        GuestEntity entity = mapper.mapFrom(dto);

        assertEquals(entity.getName(), dto.getName());
        assertEquals(entity.getPhone(), dto.getPhone());
    }
}