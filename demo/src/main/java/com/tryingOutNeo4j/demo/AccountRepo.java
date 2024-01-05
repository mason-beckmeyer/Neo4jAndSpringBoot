package com.tryingOutNeo4j.demo;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AccountRepo extends Neo4jRepository<Account,Long> {

    List<Account> getAccountByName(String name);

    Optional<Account> findById(Long id);

//    @Query("MATCH (a:Account WHERE id(a)) = $id RETURN id(a) as id, a")
//    Map<Long,Account> findAccountByIdAsMpa(Long id);

}
