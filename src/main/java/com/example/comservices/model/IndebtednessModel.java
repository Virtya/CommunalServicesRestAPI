package com.example.comservices.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@Data
@AllArgsConstructor
public class IndebtednessModel {
    @JsonProperty(value = "number")
    private Long number;

    @JsonProperty(value = "sum")
    private Long sum;
}
