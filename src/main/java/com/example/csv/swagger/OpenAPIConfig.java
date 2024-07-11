package com.example.csv.swagger;

import java.lang.annotation.Annotation;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;


@Configuration
public class OpenAPIConfig {

	@Bean
	public OpenAPI defineOpenapi() {
		Server server=new Server();
		server.setUrl("http://localhost:8080");
		server.setDescription("Development");
		
		Contact myContact=new Contact();
		myContact.setName("Prashant Sharma");
		myContact.setEmail("prashant.sharma@in2ittech.com");
		
		Info info=new Info()
				.title("CSV_Data_Entity API")
	               .version("1.0")
	               .description("This API exposes endpoints to manage employees.")
	               .contact(myContact);
		
		return new OpenAPI().info(info).servers(List.of(server));
		
	}
}
