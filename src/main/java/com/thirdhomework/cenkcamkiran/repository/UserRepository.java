package com.thirdhomework.cenkcamkiran.repository;

import java.util.Locale.Category;

import com.thirdhomework.cenkcamkiran.entities.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
