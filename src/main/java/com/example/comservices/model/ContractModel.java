package com.example.comservices.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Data
@AllArgsConstructor

public class ContractModel {
    @JsonProperty(value = "number")
    private Long number;

    @JsonProperty(value = "validity")
    private Long validity;

    @JsonProperty(value = "region")
    private Long region;

    @JsonProperty(value = "federal_law")
    private Long federalLaw;
}
