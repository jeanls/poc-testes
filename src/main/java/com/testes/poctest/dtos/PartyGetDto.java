package com.testes.poctest.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PartyGetDto {

    @JsonProperty(value = "id")
    private Integer id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "date")
    private LocalDateTime date;

    @JsonProperty(value = "locale")
    private String locale;

    @JsonProperty(value = "guests")
    private List<GuestDto> guestDtos;
}
