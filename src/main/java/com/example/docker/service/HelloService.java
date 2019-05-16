package com.example.docker.service;

import com.example.docker.entity.Hello;
import com.example.docker.repository.HelloRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

  private HelloRepository helloRepository;

  public HelloService(HelloRepository helloRepository) {
    this.helloRepository = helloRepository;
  }

  public Hello create(Hello hello) {
    return helloRepository.save(hello);
  }

  public List<Hello> getAll() {
    return helloRepository.findAll();
  }

}
