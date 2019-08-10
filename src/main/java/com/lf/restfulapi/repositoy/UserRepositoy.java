package com.lf.restfulapi.repositoy;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lf.restfulapi.domain.User;

/**
 * UserRepository interface responsible for implementing Spring Data.
 */

@Repository
public interface UserRepositoy extends MongoRepository<User, String> {

}
