package com.back.tradetier.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@SecurityScheme(
    name = "Authorization",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    scheme = "bearer"
)

public class SwaggerConfig {


    @Bean
    public OpenAPI customEpeOpenAPI(){
        return new OpenAPI()
            .info(new Info()
                .title("TradeTiere")
                .version("1.0")
                .description("Web de compra venta de animales de granja"));
    }
}
