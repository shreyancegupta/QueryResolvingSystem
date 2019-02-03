package com.app.dao;

import java.util.List;

import com.app.pojos.Teacher;

public interface TeacherDao {
	String addTeacher(Teacher teacher);
	String removeTeacher(Teacher teacher);
	Teacher retrieveTeacher(String username, String password);
	List<Teacher> getAllTeachers();
	Teacher getTeacherById(int id);
	String updateTeacher(Teacher teacher);
}
