package com.mongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mongo.collections.Users;
import com.mongo.model.User;

public interface UserRepository extends MongoRepository<User, Object> {
	
//	Users findFirstByName(String name);
//	
//	@Query( "{address: '?0'}" )
//	List<Users> findCustomByAddress(String address);
//	
//	@Query("{address : { $regex: ?0 } }")
//    List<Users> findCustomByRegExAddress(String domain);
	
	User findFirstByGameName(String gameName);

}
