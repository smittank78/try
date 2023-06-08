package com.medical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TryApplication {
	public TryApplication() {
		super();
		System.out.println("TryApplication cnstr called!!!");
	}

	public static void main(String[] args) {
		SpringApplication.run(TryApplication.class, args);
	}
	
}
