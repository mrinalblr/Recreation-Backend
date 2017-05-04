package com.mrinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.mrinal.controller","com.mrinal.service"})
public class RecreationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecreationApplication.class, args);
	}
}
