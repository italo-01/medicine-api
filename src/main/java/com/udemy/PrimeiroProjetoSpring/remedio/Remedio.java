package com.udemy.PrimeiroProjetoSpring.remedio;

import jakarta.persistence.*;
import lombok.*;


@Table(name = "Remedios")
@Entity(name = "remedios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Remedio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private Via via;
    private String lote;
    private String quantidade;
    private String validade;

    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;
}
