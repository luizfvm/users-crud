package com.lf.restfulapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lf.restfulapi.domain.User;

/**
 * UserRepository interface responsible for implementing Spring Data.
 */

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
