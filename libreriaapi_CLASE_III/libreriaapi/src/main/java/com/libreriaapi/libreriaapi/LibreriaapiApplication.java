package com.libreriaapi.libreriaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.libreriaapi.libreriaapi.repositorios")
public class LibreriaapiApplication {
	public static void main(String[] args) {
		SpringApplication.run(LibreriaapiApplication.class, args);
	}

}
