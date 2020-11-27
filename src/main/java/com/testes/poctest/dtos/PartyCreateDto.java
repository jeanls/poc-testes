package com.testes.poctest.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PartyCreateDto {

    @NotNull
    @NotBlank
    @Size(max = 50)
    @JsonProperty(value = "name")
    private String name;

    @NotNull
    @NotBlank
    @JsonProperty(value = "date")
    private String date;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @JsonProperty(value = "locale")
    private String locale;
}
