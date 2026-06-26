package com.udemy.PrimeiroProjetoSpring.remedio;

import java.time.LocalDate;

public record DadosListagemRemedios(String nome, Via via, String lote, Laboratorio laboratorio, LocalDate validade) {
    public DadosListagemRemedios(Remedio remedio){
        this(remedio.getNome(), remedio.getVia(), remedio.getLote(), remedio.getLaboratorio(), remedio.getValidade());
    }
}
