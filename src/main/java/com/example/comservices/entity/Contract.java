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

public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @JoinColumn(name = "number")
    private Long number;

    @NotNull
    private String validity;

    @NotNull
    private String region;

    @NotNull
    private String federal_law;
}
