package com.test.ems;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Employee Management Service REST API Documentation",
				description = "Employee Management REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Ravindra Bankapur",
						email = "brs.rav@gmail.com",
						url = "https://localhost:8090/swgger-ui/index.html"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://localhost:8090/swgger-ui/index.html"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "",
				url = "https://localhost:8090/swgger-ui/index.html"
		)
)
@SpringBootApplication
public class EmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
	}

}
