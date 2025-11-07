package io.github.jvictor12.TestePratico.utils;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    //Config para usar o Swagger
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Teste Prático - Photos")
                        .version("1.0")
                        .description("API para buscar e salvar fotos de gatos usando The Cat API.")
                        .contact(new Contact()
                                .name("João Victor")
                                .email("01joaovictordvp@gmail.com")
                                .url("https://github.com/Jvictor12")));
    }
}

