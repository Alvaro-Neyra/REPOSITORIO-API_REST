package com.libreriaapi.libreriaapi.configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfiguracionCORS implements WebMvcConfigurer{

    // Solo las solicitudes HTTP con métodos GET, POST, PUT, PATCH y DELETE desde el dominio http://localhost:3000 serán aceptadas por tu backend.
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000")
            .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE")
            .allowedHeaders("*");
    }
}
