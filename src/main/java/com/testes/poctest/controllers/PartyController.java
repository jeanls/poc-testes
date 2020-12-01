package com.testes.poctest.controllers;

import com.testes.poctest.dtos.PartyCreateDto;
import com.testes.poctest.dtos.PartyGetDto;
import com.testes.poctest.dtos.PartyUpdateDto;
import com.testes.poctest.services.PartyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping(path = "/{id}")
    public ResponseEntity<PartyGetDto> get(@PathVariable("id") final Integer id) {
        final PartyGetDto partyGetDto = partyService.get(id);

        return ResponseEntity.ok(partyGetDto);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PartyGetDto> delete(@PathVariable("id") final Integer id) {
        partyService.delete(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PartyGetDto>> index(
            @RequestParam(value = "search", required = false, defaultValue = "") final String search,
            @RequestParam(value = "page", required = false, defaultValue = "0") final Integer page
    ) {
        final List<PartyGetDto> partyGetDtos = partyService.index(search, page);

        return ResponseEntity.ok(partyGetDtos);
    }
}
