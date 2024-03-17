package com.blackpearl.nosql.mongodbdemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blackpearl.nosql.mongodbdemo.entity.School;

@Repository
public interface SchoolRepository extends MongoRepository<School, String> {

}