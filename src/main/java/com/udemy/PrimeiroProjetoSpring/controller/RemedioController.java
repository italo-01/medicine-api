package com.udemy.PrimeiroProjetoSpring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.udemy.PrimeiroProjetoSpring.DTOs.DadosAtualizarRemedio;
import com.udemy.PrimeiroProjetoSpring.DTOs.DadosCadastroRemedio;
import com.udemy.PrimeiroProjetoSpring.DTOs.DadosDetalhamentoRemedio;
import com.udemy.PrimeiroProjetoSpring.DTOs.DadosListagemRemedios;
import com.udemy.PrimeiroProjetoSpring.remedio.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/remedio")
@Tag(name = "Remedios ", description = "Geranciador de Remedios")
public class RemedioController {

    @Autowired
    private RemedioRepository repository;



    @PostMapping
    @Transactional
    @Operation(summary = "Cadastrar Remedios", description = "Cadastra um Novo remedio")
    public ResponseEntity<DadosDetalhamentoRemedio> cadastrar(@RequestBody @Valid DadosCadastroRemedio dados, UriComponentsBuilder uribuilder) {
        var remedio = new Remedio(dados);
        repository.save(remedio);

        var uri = uribuilder.path("/remedios/{id}").buildAndExpand(remedio.getId()).toUri();

        return  ResponseEntity.created(uri).body(new DadosDetalhamentoRemedio(remedio));
    }

    @Operation(summary = "Listar Remedios", description = "Listar todos os remedios")
    @GetMapping
    public ResponseEntity<List<DadosListagemRemedios>> listar() {
        var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemRemedios::new).toList();

        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Atualizar Remedio", description = "Atualizar Remedio escolhido")
    public ResponseEntity<DadosDetalhamentoRemedio> atualizar(@RequestBody @Valid DadosAtualizarRemedio dados) {
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);


        return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Excluir Remedio", description = "Esclui Remedio escolhido")
    public ResponseEntity<Void>deletar(@PathVariable long id){
          repository.deleteById(id);

          return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/inativar/{id}")
    @Transactional
    @Operation(summary = "Inativar Remedio", description = "Deixa o Remedio inativo")
    public ResponseEntity<Void> inativar (@PathVariable long id){
        var remedio = repository.getReferenceById(id);
        remedio.inativarRemedio();

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/ativar/{id}")
    @Transactional
    @Operation(summary = "Ativar Remedio", description = "Deixa Remedio Ativo")
    public ResponseEntity<Void> ativar(@PathVariable long id){
        var remedio = repository.getReferenceById(id);
        remedio.ativarRemedio();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    @Operation(summary = "Buscar remedio", description = "Busca o remdio escolhido pelo ID")
    public ResponseEntity<DadosDetalhamentoRemedio> buscar(@PathVariable long id){
        var remedio = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));
    }
}