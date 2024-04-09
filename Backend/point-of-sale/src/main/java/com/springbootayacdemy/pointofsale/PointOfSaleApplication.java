package com.springbootayacdemy.pointofsale;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class PointOfSaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PointOfSaleApplication.class, args);
	}

}