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
/*@Table(name = "contract")*/

public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Long id;

    @NotNull
    @JoinColumn(name = "number")
    @ManyToOne
    private Individual individual;

    @NotNull
    private Long validity;

    @NotNull
    private String region;

    @NotNull
    private String federalLaw;
}
