package net.javaguides.springboot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring boot REST API documentation",
				description = "Spring boot REST API documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Ashok",
						email = "munagantiashokkumar@gmail.com",
						url = "https:/www.javaguides.net"
						),
				license = @License(
						name = "Apache 2.0",
						url = "https:/www.javaguides.net/licence"
						)
				),
		externalDocs = @ExternalDocumentation(
				description = "Spring boot USER management documentation",
				url = "https:/www.javaguides.net/user_management.html"
				)
		
		
		)
public class SpringBootResTfulWebservicesApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootResTfulWebservicesApplication.class, args);
	}

}
