package com.blackpearl.nosql.mongodbdemo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.blackpearl.nosql.mongodbdemo.entity.Student;


@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

	List<Student> findByName(String name);
	
	List<Student> findByNameOrEmail(String name, String email);
	
	List<Student> findByDeptDeptName(String deptName);
	
	List<Student> findBySubjectsSubName(String subName);
	
	List<Student> findByEmailIsLike(String email);
	
	List<Student> findByNameIsStartingWith(String word);
	
	List<Student> findByNameIsEndingWith(String word);
	
	List<Student> findBySchoolId(String deptId);
	
	@Query("{\"name\": \"?0\"}")
	List<Student> findByStudentName(String name);
	
	@Query(value = "{}", fields = "{name : 1, email: 1, id: 0}")
	List<Student> findAllNameAndMail();
}