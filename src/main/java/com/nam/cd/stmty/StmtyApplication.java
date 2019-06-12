package com.nam.cd.stmty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories("com.nam.cd.stmty")
public class StmtyApplication {

	public static void main(String[] args) {
		SpringApplication.run(StmtyApplication.class, args);
	}

}
