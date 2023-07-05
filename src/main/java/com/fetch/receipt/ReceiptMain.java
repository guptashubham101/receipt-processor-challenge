package com.fetch.receipt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class ReceiptMain {

	// Main Class
	public static void main(String[] args) {
		SpringApplication.run(ReceiptMain.class, args);
	}
}