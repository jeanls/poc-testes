package com.testes.poctest.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GuestCreateDto {

    @NotNull
    @JsonProperty(value = "party_id")
    private Integer partyId;

    @NotNull
    @NotBlank
    @JsonProperty(value = "name")
    private String name;

    @NotNull
    @NotBlank
    @JsonProperty(value = "phone")
    private String phone;
}
