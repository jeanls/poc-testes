package com.testes.poctest.services;

import com.testes.poctest.dtos.GuestCreateDto;
import com.testes.poctest.entities.PartyEntity;
import com.testes.poctest.exceptions.NotFoundException;
import com.testes.poctest.repositories.GuestRepository;
import com.testes.poctest.repositories.PartyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GuestServiceTest {

    @InjectMocks
    private GuestService guestService;

    @Mock
    private PartyRepository partyRepository;

    @Test(expected = NotFoundException.class)
    public void addGuestTestNotFoundException() {
        guestService.addGuest(new GuestCreateDto());
    }

    @Test
    public void addGuestTest() {
        GuestCreateDto guestCreateDto = new GuestCreateDto();
        guestCreateDto.setPhone("(11) 98877-2222");
        guestCreateDto.setPartyId(1);
        guestCreateDto.setName("John Doe");

        PartyEntity partyEntity = new PartyEntity();

        Mockito.when(partyRepository.findById(guestCreateDto.getPartyId()))
                .thenReturn(Optional.of(partyEntity));

        guestService.addGuest(guestCreateDto);

        assertEquals(1, partyEntity.getGuestEntities().size());
    }
}