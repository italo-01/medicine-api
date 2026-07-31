package com.udemy.PrimeiroProjetoSpring;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI(){

        return new OpenAPI().info(new Info()
                .title("REMEDIOS")
                .version("1.0.0")
                .description("Documento da Cafetaria API")
        );

    }

}
