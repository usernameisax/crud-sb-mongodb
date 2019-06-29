package com.usernameisax.crud.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.usernameisax.crud.api.documents.Cliente;

public interface ClieteRepository extends MongoRepository<Cliente, String> {

}
