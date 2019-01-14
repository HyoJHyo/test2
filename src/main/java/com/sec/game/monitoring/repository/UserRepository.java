package com.sec.game.monitoring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sec.game.monitoring.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
