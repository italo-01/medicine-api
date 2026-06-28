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
        return repository.findAllByAtivoTrue().stream().map(DadosListagemRemedios::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarRemedio dados) {
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable long id){
        repository.deleteById(id);
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public void inativar (@PathVariable long id){
        var remedio = repository.getReferenceById(id);
        remedio.inativarRemedio();
    }

    @PutMapping("ativar/{id}")
    @Transactional
    public void ativar(@PathVariable long id){
        var remedio = repository.getReferenceById(id);
        remedio.ativarRemedio();
    }
}