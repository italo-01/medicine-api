package com.udemy.PrimeiroProjetoSpring;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI(){

        return new OpenAPI();

    }

}
