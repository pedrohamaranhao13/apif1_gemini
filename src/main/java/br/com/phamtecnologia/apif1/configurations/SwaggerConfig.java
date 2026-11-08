package br.com.phamtecnologia.apif1.configurations;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Fórmula 1 - Pedro Maranhão")
                        .version("1.0.0")
                        .description("Documentação interativa da API de gestão de pilotos construída com Spring Boot."));
    }

}
