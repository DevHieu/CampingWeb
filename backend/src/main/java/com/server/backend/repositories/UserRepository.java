package com.server.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.server.backend.models.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
  boolean existsByEmail(String email);

  User findByUsername(String username);

  User findByEmail(String email);
}
