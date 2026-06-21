package com.udemy.PrimeiroProjetoSpring.controller;

import com.udemy.PrimeiroProjetoSpring.remedio.DadosCadastroRemedio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/remedio")
public class RemedioController {
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroRemedio dados){
        System.out.println(dados);

    }
}
