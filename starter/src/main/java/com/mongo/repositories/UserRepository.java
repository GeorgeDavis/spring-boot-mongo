package com.mongo.repositories;

import com.mongo.collections.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    // Users findFirstByName(String name);
    //
    // @Query( "{address: '?0'}" )
    // List<Users> findCustomByAddress(String address);

    User findUserByLastName(String lastName);

    @Query("{gameName : { $regex: ?0 } }")
    List<User> findCustomByRegExGameName(String domain);

    User findFirstByGameName(String gameName);

    List<User> getUsersByGameName(String gameName);

}
