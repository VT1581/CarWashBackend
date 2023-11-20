package com.na.carwash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CarWasherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarWasherServiceApplication.class, args);
	}

}
