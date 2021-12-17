package com.example.comservices.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder

public class Individual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @NotNull
    private String fio;

    @NotNull
    private String gender;

    @NotNull
    private String birthDate;
}
