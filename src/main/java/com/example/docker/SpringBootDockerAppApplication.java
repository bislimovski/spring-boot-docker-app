package com.example.docker;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import com.example.docker.entity.Hello;
import com.example.docker.service.HelloService;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootDockerAppApplication {

	private HelloService helloService;

	public SpringBootDockerAppApplication(HelloService helloService) {
		this.helloService = helloService;
	}

	@RequestMapping("/")
	public String home() {
		return "Hello from Docker" + "<br><br>" +
		"routes: " + "<br><br>" +
				"baseUrl/save " + "<br>" +
				"baseUrl/get-all";
	}

	@RequestMapping("/save")
	public ResponseEntity<Void> save() {

		Hello hello = new Hello("Hello from docker-mongodb");

		Hello savedHello = this.helloService.create(hello);

		if(savedHello != null) {
			return ResponseEntity.status(OK).build();
		}
		return ResponseEntity.status(BAD_REQUEST).build();
	}


	@RequestMapping("/get-all")
	public ResponseEntity getAll() {

		List<Hello> helloList = helloService.getAll();

		if(helloList.isEmpty()) {
			return ResponseEntity.status(NOT_FOUND).build();
		}

		return ResponseEntity.ok(helloList);
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerAppApplication.class, args);
	}

}
