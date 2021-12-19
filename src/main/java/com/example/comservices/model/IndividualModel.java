package com.example.comservices.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class IndividualModel {
    @JsonProperty(value = "fio")
    private String fio;

    @JsonProperty(value = "gender")
    private String gender;

    @JsonProperty(value = "birth_date")
    private String birth_date;
}