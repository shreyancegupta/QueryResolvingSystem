package com.app.service;

import java.util.List;

import com.app.pojos.Student;
import com.app.pojos.Subject;
import com.app.pojos.Teacher;

public interface AdminService {
	String addStudent(Student student);
	String removeStudent(Student student);
	Student getStudentById(int id);
	String updateStudent(Student student);
	List<Student> getAllStudents();
	String addTeacher(Teacher teacher);
	Teacher getTeacherById(int id);
	String updateTeacher(Teacher teacher);
	String removeTeacher(Teacher teacher);
	List<Teacher> getAllTeachers();
	String addSubject(Subject subject);
	String removeSubject(Subject subject);
	List<Subject> getAllSubjects();
//	String updatePassword(String email, String password, String role);
	String updatePassword(Object object, String password);
}
