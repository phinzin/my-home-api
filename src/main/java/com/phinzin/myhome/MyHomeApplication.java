package com.phinzin.myhome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;

@SpringBootApplication
@EnableCosmosRepositories
public class MyHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyHomeApplication.class, args);
	}

}
