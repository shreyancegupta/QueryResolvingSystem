package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Student;
import com.app.pojos.Teacher;

@Repository
public class TeacherDaoImpl implements TeacherDao {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public String addTeacher(Teacher teacher) {
		sf.getCurrentSession().save(teacher);
		return "Teacher added successfully.";
	}

	@Override
	public String removeTeacher(Teacher teacher) {
		sf.getCurrentSession().delete(teacher);
		return "Teacher deleted successfully.";
	}

	@Override
	public Teacher retrieveTeacher(String username, String password) {
		String jpql = "SELECT t FROM Teacher t WHERE t.email=:un AND t.password=:pass";
		
		return sf.getCurrentSession().createQuery(jpql, Teacher.class).setParameter("un", username).setParameter("pass", password).getSingleResult();
	}

	@Override
	public List<Teacher> getAllTeachers() {
		String jpql = "SELECT t FROM Teacher t";
		return sf.getCurrentSession().createQuery(jpql, Teacher.class).getResultList();
	}

	@Override
	public Teacher getTeacherById(int id) {
		return sf.getCurrentSession().get(Teacher.class, id);
	}

	@Override
	public String updateTeacher(Teacher teacher) {
		sf.getCurrentSession().update(teacher);
		return "Teacher details updated";
	}

}
