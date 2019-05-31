package com.example.docker.repository;

import com.example.docker.entity.Hello;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepository extends MongoRepository<Hello, String> {

}
