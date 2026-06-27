package com.udemy.PrimeiroProjetoSpring.remedio;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;


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
    private int quantidade;
    private LocalDate validade;

    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;

    public Remedio(DadosCadastroRemedio dados) {
        this.nome = dados.nome();
        this.via = dados.via();
        this.lote = dados.lote();
        this.quantidade = dados.quantidade();
        this.validade = dados.validade();
        this.laboratorio = dados.laboratorio();
    }

    public void atualizarInformacoes(@Valid DadosAtualizarRemedio dados) {
        if (dados.nome () != null){
            this.nome = dados.nome();
        }
        if (dados.via() != null){
            this.via = dados.via();
        }
        if (dados.laboratorio() != null){
            this.laboratorio = dados.laboratorio();
        }
    }
}



