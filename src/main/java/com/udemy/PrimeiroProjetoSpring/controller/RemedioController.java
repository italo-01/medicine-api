package com.udemy.PrimeiroProjetoSpring.controller;

import com.udemy.PrimeiroProjetoSpring.remedio.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remedio")
public class RemedioController {

    @Autowired
    private RemedioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroRemedio dados) {
        repository.save(new Remedio(dados));

    }

    @GetMapping
    public List<DadosListagemRemedios> listar() {
        return repository.findAll().stream().map(DadosListagemRemedios::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarRemedio dados) {
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);
    }
    @DeleteMapping
    @Transactional
    public void deletar(DadosDeletarRemedio dados){

    }
}