package com.testes.poctest.controllers;

import com.testes.poctest.dtos.GuestCreateDto;
import com.testes.poctest.services.GuestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/guests")
@AllArgsConstructor
public class GuestController {

    private final GuestService guestService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addGuest(@RequestBody @Valid final GuestCreateDto guestCreateDto) {
        guestService.addGuest(guestCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
