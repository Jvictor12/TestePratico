package io.github.jvictor12.TestePratico.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfig {

    @Value("${API_KEY:}")
    private String apiKey;

    //criando WebClient e buildando a url com a ApiKey criada
    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder
                .baseUrl("https://api.thecatapi.com/v1")
                .defaultHeader("x-api-key", apiKey)
                .build();
    }
}

