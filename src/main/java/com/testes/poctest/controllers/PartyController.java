package com.testes.poctest.controllers;

import com.testes.poctest.dtos.PartyCreateDto;
import com.testes.poctest.dtos.PartyUpdateDto;
import com.testes.poctest.services.PartyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/parties")
public class PartyController {

    private final PartyService partyService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody @Valid final PartyCreateDto partyCreateDto) {
        partyService.create(partyCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(@RequestBody @Valid final PartyUpdateDto partyUpdateDto) {
        partyService.update(partyUpdateDto);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
