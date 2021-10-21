package com.github.KluevJakov.StoreClosure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class StoreClosureApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreClosureApplication.class, args);
	}

}
