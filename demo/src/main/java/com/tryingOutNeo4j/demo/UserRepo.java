package com.tryingOutNeo4j.demo;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends Neo4jRepository<User,Long> {

    List<User> getUserByLastName(String lastName);

    Optional<User> findById(Long id);

}
