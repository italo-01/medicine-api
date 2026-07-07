package com.udemy.PrimeiroProjetoSpring.controller;

import com.udemy.PrimeiroProjetoSpring.infra.TokenService;
import com.udemy.PrimeiroProjetoSpring.usuarios.DadosAutenticacao;
import com.udemy.PrimeiroProjetoSpring.usuarios.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenservice;

    @PostMapping
    public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        var token  = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authenticacao = manager.authenticate(token);

        return ResponseEntity.ok(tokenservice.gerarToken((Usuario) authenticacao.getPrincipal()));
    }
}

