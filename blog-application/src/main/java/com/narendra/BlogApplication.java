package com.narendra;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Blog API", version = "1.1.0", description = "About Blog API by Narendra"))
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI().info(new io.swagger.v3.oas.models.info.Info().title("Blog App")
				.version("v0.0.1")
				.license(new License().name("Apache 2.0")
				.url("http://springdoc.org")))
				.externalDocs(new ExternalDocumentation()
						.description("SpringShop Wiki Documentation")
				.url("https://springshop.wiki.github.org/docs"));

	}
}

// My New Changes and testing commit