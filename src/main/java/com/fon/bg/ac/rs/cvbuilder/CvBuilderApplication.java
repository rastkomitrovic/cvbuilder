package com.fon.bg.ac.rs.cvbuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableCaching
@EnableWebSecurity
@EnableTransactionManagement
@EnableJpaRepositories
public class CvBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CvBuilderApplication.class, args);
	}

}
