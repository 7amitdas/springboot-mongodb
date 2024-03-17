package com.blackpearl.nosql.mongodbdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.blackpearl.nosql.mongodbdemo.entity.Student;
import com.blackpearl.nosql.mongodbdemo.repository.GameRepository;
import com.blackpearl.nosql.mongodbdemo.repository.SchoolRepository;
import com.blackpearl.nosql.mongodbdemo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private SchoolRepository schoolRepo;
	
	@Autowired
	private GameRepository gameRepo;

	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}
	
	public List<Student> getAllStudentsNameAndMail() {
		return studentRepo.findAllNameAndMail();
	}

	public List<Student> getAllStudentsWithPagination(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return studentRepo.findAll(pageable).getContent();
	}
	
	public List<Student> getAllStudentsWithSorting() {
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		return studentRepo.findAll(sort);
	}

	public List<Student> getStudentByName(String name) {
		return studentRepo.findByStudentName(name);
	}
	
	public List<Student> getStudentByDepartmentName(String deptName) {
		return studentRepo.findByDeptDeptName(deptName);
	}
	
	public List<Student> getStudentBySubjectName(String subName) {
		return studentRepo.findByDeptDeptName(subName);
	}
	
	public List<Student> getAllStudentsByLikelyEmail(String email) {
		return studentRepo.findByEmailIsLike(email);
	}
	
	public List<Student> getAllStudentsStartsWithWord(String word) {
		return studentRepo.findByNameIsStartingWith(word);
	}
	
	public List<Student> getAllStudentsEndsWithWord(String word) {
		return studentRepo.findByNameIsEndingWith(word);
	}
	
	public List<Student> getAllStudentsBySchoolId(String schoolId) {
		return studentRepo.findBySchoolId(schoolId);
	}

	public Student createStudent(Student student) {
		if (student.getSchool() != null) {
			schoolRepo.save(student.getSchool());
		}
		if (student.getGames() != null && student.getGames().size() > 0) {
			gameRepo.saveAll(student.getGames());
		}
		return studentRepo.save(student);
	}

	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}

	public String deleteStudent(String id) {
		studentRepo.deleteById(id);
		return "Deleted";
	}
}