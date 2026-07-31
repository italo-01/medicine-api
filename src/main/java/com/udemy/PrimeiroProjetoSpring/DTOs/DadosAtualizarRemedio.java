package com.udemy.PrimeiroProjetoSpring.DTOs;

import com.udemy.PrimeiroProjetoSpring.remedio.Laboratorio;
import com.udemy.PrimeiroProjetoSpring.remedio.Via;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarRemedio(
        @NotNull
        long id,

        String nome,

        Via via,

        Laboratorio laboratorio
) {

}
