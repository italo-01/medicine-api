package com.udemy.PrimeiroProjetoSpring.DTOs;

import com.udemy.PrimeiroProjetoSpring.remedio.Laboratorio;
import com.udemy.PrimeiroProjetoSpring.remedio.Remedio;
import com.udemy.PrimeiroProjetoSpring.remedio.Via;

import java.time.LocalDate;

public record DadosListagemRemedios(long id, String nome, Via via, String lote, Laboratorio laboratorio, LocalDate validade) {
    public DadosListagemRemedios(Remedio remedio){
        this(remedio.getId(), remedio.getNome(), remedio.getVia(), remedio.getLote(), remedio.getLaboratorio(), remedio.getValidade());

    }
}
