package com.testes.poctest.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GuestDto {

    @JsonProperty(value = "id")
    private Integer id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "entry_at")
    private LocalDateTime entryAt;

    @JsonProperty(value = "phone")
    private String phone;
}
