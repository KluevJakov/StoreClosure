package com.github.KluevJakov.StoreClosure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.github.KluevJakov.StoreClosure.entity")
@EnableJpaRepositories("com.github.KluevJakov.StoreClosure.repository")
@ComponentScan({"com.github.KluevJakov.StoreClosure.controller", "com.github.KluevJakov.StoreClosure.configuration"})
public class StoreClosureApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreClosureApplication.class, args);
	}

}
