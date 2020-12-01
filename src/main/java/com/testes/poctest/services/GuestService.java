package com.testes.poctest.services;

import com.testes.poctest.dtos.GuestCreateDto;
import com.testes.poctest.entities.GuestEntity;
import com.testes.poctest.entities.PartyEntity;
import com.testes.poctest.exceptions.NotFoundException;
import com.testes.poctest.mappers.GuestMapper;
import com.testes.poctest.repositories.PartyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class GuestService {

    private final PartyRepository partyRepository;

    @Transactional
    public void addGuest(final GuestCreateDto guestCreateDto) {
        final PartyEntity partyEntity = partyRepository.findById(guestCreateDto.getPartyId())
                .orElseThrow(() -> new NotFoundException("Festa não encontrada"));

        final GuestEntity guestEntity = GuestMapper.INSTANCE.mapFrom(guestCreateDto);

        partyEntity.addGuest(guestEntity);
    }
}
