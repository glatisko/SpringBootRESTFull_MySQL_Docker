package com.example.exploremnjpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.exploremnjpa.business.TourPackageService;
import com.example.exploremnjpa.business.TourService;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.apache.commons.lang3.StringUtils;


@SpringBootApplication
public class ExploremnJpaApplication implements CommandLineRunner {

	@Bean
	public OpenAPI swaggerHeader() {
		return new OpenAPI()
				.info((new Info())
						.description("Services for the Explore California Relational Database.")
						.title(StringUtils.substringBefore(getClass().getSimpleName(), "$"))
						.version("3.0.0"));
	}


	@Autowired
	private TourPackageService tourPackageService;

	@Autowired
	private TourService tourService;

	public static void main(String[] args) {

		SpringApplication.run(ExploremnJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Persisted Packages = " + tourPackageService.total());
		System.out.println("Persisted Tours = " + tourService.total());
	}
}
