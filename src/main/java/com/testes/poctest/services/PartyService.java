package com.testes.poctest.services;

import com.testes.poctest.dtos.PartyCreateDto;
import com.testes.poctest.dtos.PartyGetDto;
import com.testes.poctest.dtos.PartyUpdateDto;
import com.testes.poctest.entities.PartyEntity;
import com.testes.poctest.exceptions.NotFoundException;
import com.testes.poctest.mappers.PartyMapper;
import com.testes.poctest.repositories.PartyRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    public PartyGetDto get(final Integer id) {
        final PartyEntity partyEntity = partyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Festa não encontrada"));

        return PartyMapper.INSTANCE.mapFrom(partyEntity);
    }

    public void delete(final Integer id) {
        final PartyEntity partyEntity = partyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Festa não encontrada"));

        partyRepository.delete(partyEntity);
    }

    public List<PartyGetDto> index(final String search, final Integer page) {
        final Page<PartyEntity> partyEntities = partyRepository.index(search, PageRequest.of(page, 10));
        final Page<PartyGetDto> partyGetDtos = PartyMapper.INSTANCE.mapFrom(partyEntities);

        return partyGetDtos.getContent();
    }
}
