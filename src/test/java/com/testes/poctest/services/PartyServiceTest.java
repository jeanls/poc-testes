package com.testes.poctest.services;

import com.testes.poctest.dtos.PartyCreateDto;
import com.testes.poctest.entities.PartyEntity;
import com.testes.poctest.repositories.PartyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PartyServiceTest {

    @InjectMocks
    private PartyService partyService;

    @Mock
    private PartyRepository partyRepository;

    @Test
    public void createTest() {
        PartyCreateDto partyCreateDto = new PartyCreateDto();
        partyCreateDto.setDate(null);
        partyCreateDto.setLocale("SP");
        partyCreateDto.setName("John Doe");
        partyService.create(partyCreateDto);

        //VOID
        Mockito.verify(partyRepository, Mockito.times(1)).save(Mockito.any(PartyEntity.class));
    }
}