package com.blackpearl.nosql.mongodbdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blackpearl.nosql.mongodbdemo.entity.Student;
import com.blackpearl.nosql.mongodbdemo.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/namemail")
	public List<Student> getAllStudentsNameAndMail() {
		return studentService.getAllStudentsNameAndMail();
	}
	
	@GetMapping("/pagination")
	public List<Student> getAllStudentsWithPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
		return studentService.getAllStudentsWithPagination(pageNo, pageSize);
	}
	
	@GetMapping("/sorting")
	public List<Student> getAllStudentsWithSorting() {
		return studentService.getAllStudentsWithSorting();
	}
	
	@GetMapping("/{name}")
	public List<Student> getAllStudentsByName(@PathVariable("name") String name) {
		return studentService.getStudentByName(name);
	}
	
	@GetMapping("/department")
	public List<Student> getAllStudentsByDepartmentName(@RequestParam("deptName") String deptName) {
		return studentService.getStudentByDepartmentName(deptName);
	}
	
	@GetMapping("/subject")
	public List<Student> getAllStudentsBySubjectName(@RequestParam("subName") String subName) {
		return studentService.getStudentBySubjectName(subName);
	}
	
	@GetMapping("/likeemail")
	public List<Student> getAllStudentsByLikelyEmail(@RequestParam("email") String email) {
		return studentService.getAllStudentsByLikelyEmail(email);
	}
	
	@GetMapping("/namestartswith")
	public List<Student> getAllStudentsStartsWithWord(@RequestParam("word") String startsWith) {
		return studentService.getAllStudentsStartsWithWord(startsWith);
	}
	
	@GetMapping("/nameendswith")
	public List<Student> getAllStudentsEndsWithWord(@RequestParam("word") String endsWith) {
		return studentService.getAllStudentsEndsWithWord(endsWith);
	}
	
	@GetMapping("/school/{name}")
	public List<Student> getAllStudentsBySchoolId(@PathVariable("name") String schoolName) {
		return studentService.getAllStudentsBySchoolId(schoolName);
	}
	
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable String id) {
		return studentService.deleteStudent(id);
	}
}