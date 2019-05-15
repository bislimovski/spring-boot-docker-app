package com.example.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootDockerAppApplication {

	@RequestMapping("/")
	public String home() {
		return "Hello from Docker";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerAppApplication.class, args);
	}

}
