package com.app.dao;

import java.util.List;

import com.app.pojos.Student;

public interface StudentDao {
	String addStudent(Student student);
	String removeStudent(Student student);
	Student retrieveStudent(String username, String password);
	List<Student> getAllStudents();
	Student getStudentById(int id);
	String updateStudent(Student student);
}
