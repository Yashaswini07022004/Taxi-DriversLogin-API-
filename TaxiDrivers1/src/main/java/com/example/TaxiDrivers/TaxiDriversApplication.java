package com.example.TaxiDrivers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "TaxiDrivers API", version = "2.0", description = "Registration_Info"))
@EnableMongoRepositories(basePackages = "com.example.TaxiDrivers.Repository")
@EnableMongoAuditing
public class TaxiDriversApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxiDriversApplication.class, args);
	}

}
