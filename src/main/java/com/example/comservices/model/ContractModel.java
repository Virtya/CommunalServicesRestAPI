package com.example.comservices.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Data
@AllArgsConstructor

public class ContractModel {
    @JsonProperty(value = "number")
    private Long number;

    @JsonProperty(value = "validity")
    private String validity;

    @JsonProperty(value = "region")
    private String region;

    @JsonProperty(value = "federal_law")
    private String federalLaw;
}
