package com.example.comservices.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Builder
@AllArgsConstructor

public class Indebtedness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @JoinColumn(name = "number")
    @ManyToOne
    private Individual individual;

    @NotNull
    private Long sum;
}
