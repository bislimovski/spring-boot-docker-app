package com.example.docker;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

//import com.example.docker.entity.Hello;
//import com.example.docker.service.HelloService;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootDockerAppApplication {

//	private HelloService helloService;
//
//	public SpringBootDockerAppApplication(HelloService helloService) {
//		this.helloService = helloService;
//	}

	Logger logger = LoggerFactory.getLogger(SpringBootDockerAppApplication.class);

	@RequestMapping("/")
	public String home() {
		return "Hello from Docker!!!" + "<br><br>" +
		"routes: " + "<br><br>" +
				"baseUrl/save " + "<br>" +
				"baseUrl/get-all";
	}

	@RequestMapping("/file")
	public ResponseEntity<Void> file() {

		try {

//			String path = System.getProperty("user.home");
			String path = "/var";

			//create test.txt
			List<String> lines = Arrays.asList("The first line", "The second line");
			Path file = Paths.get(path + "/test.txt");
			Files.write(file, lines, Charset.forName("UTF-8"));

			//create test2.txt
			new PrintStream(new FileOutputStream(path + "/test2.txt"));

			logger.info("************************" + path +"********************");
			return ResponseEntity.status(OK).build();
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			logger.error(e.getCause().toString());
			return ResponseEntity.status(BAD_REQUEST).build();
		}
	}

//	@RequestMapping("/save")
//	public ResponseEntity<Void> save() {
//
//		Hello hello = new Hello("Hello from docker-mongodb");
//
//		Hello savedHello = this.helloService.create(hello);
//
//		if(savedHello != null) {
//			return ResponseEntity.status(OK).build();
//		}
//		return ResponseEntity.status(BAD_REQUEST).build();
//	}
//
//
//	@RequestMapping("/get-all")
//	public ResponseEntity getAll() {
//
//		List<Hello> helloList = helloService.getAll();
//
//		if(helloList.isEmpty()) {
//			return ResponseEntity.status(NOT_FOUND).build();
//		}
//
//		return ResponseEntity.ok(helloList);
//	}


	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerAppApplication.class, args);
	}

}
