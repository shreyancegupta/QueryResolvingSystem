package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public String addStudent(Student student) {
		sf.getCurrentSession().save(student);
		return "Student added successfully.";
	}

	@Override
	public String removeStudent(Student student) {
		sf.getCurrentSession().delete(student);
		return "Student deleted successfully.";
	}

	@Override
	public Student retrieveStudent(String username, String password) {
		String jpql = "SELECT s FROM Student s WHERE s.email=:un AND s.password=:pass";
		return sf.getCurrentSession().createQuery(jpql, Student.class).setParameter("un", username).setParameter("pass", password).getSingleResult();
	}

	@Override
	public List<Student> getAllStudents() {
		String jpql = "SELECT s FROM Student s";
		return sf.getCurrentSession().createQuery(jpql, Student.class).getResultList();
	}

	@Override
	public Student getStudentById(int id) {
		return sf.getCurrentSession().get(Student.class, id);
	}

	@Override
	public String updateStudent(Student student) {
		sf.getCurrentSession().update(student);
		return "Student details updated";
	}

}
