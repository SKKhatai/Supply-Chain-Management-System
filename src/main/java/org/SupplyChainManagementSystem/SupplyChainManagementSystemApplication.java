package org.SupplyChainManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SupplyChainManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplyChainManagementSystemApplication.class, args);
		System.out.println("SpringBoot Application Started");
	}

}
