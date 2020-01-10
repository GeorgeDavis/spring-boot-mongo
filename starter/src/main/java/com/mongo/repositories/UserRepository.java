package com.mongo.repositories;

import com.mongo.collections.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {


    // @Query( "{address: '?0'}" )
    // List<Users> findCustomByAddress(String address);

    User findUserByLastName(String lastName);

//    @Query("{gameName : { $regex: ?0 } }")
//    List<User> findCustomByRegExGameName(String domain);

    List<User> getUsersByGameName(String gameName);

}
