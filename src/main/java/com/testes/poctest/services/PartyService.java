package com.testes.poctest.services;

import com.testes.poctest.dtos.PartyCreateDto;
import com.testes.poctest.dtos.PartyUpdateDto;
import com.testes.poctest.entities.PartyEntity;
import com.testes.poctest.exceptions.NotFoundException;
import com.testes.poctest.mappers.PartyMapper;
import com.testes.poctest.repositories.PartyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class PartyService {

    private final PartyRepository partyRepository;

    @Transactional
    public void create(final PartyCreateDto partyCreateDto) {
        final PartyEntity partyEntity = PartyMapper.INSTANCE.mapFrom(partyCreateDto);

        partyRepository.save(partyEntity);
    }

    @Transactional
    public void update(final PartyUpdateDto partyUpdateDto) {
        final PartyEntity partyEntity = partyRepository.findById(partyUpdateDto.getId())
                .orElseThrow(() -> new NotFoundException("Festa não encontrada"));

        final PartyEntity toUpdate = PartyMapper.INSTANCE.mapFrom(partyUpdateDto);

        partyEntity.setDate(toUpdate.getDate());
        partyEntity.setName(toUpdate.getName());
        partyEntity.setLocale(toUpdate.getLocale());

        partyRepository.save(partyEntity);
    }
}
