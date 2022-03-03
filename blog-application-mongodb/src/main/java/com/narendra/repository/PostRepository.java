package com.narendra.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.narendra.entity.Post;


public interface PostRepository extends MongoRepository<Post, Long>{

}