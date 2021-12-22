package com.thirdhomework.cenkcamkiran.repository;

import com.thirdhomework.cenkcamkiran.entities.ProductComment;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCommentRepository extends MongoRepository<ProductComment, String> {

}
