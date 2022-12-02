package com.sp2.apirestmongo.repository.mongorepository;

import com.sp2.apirestmongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserMongoRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
