package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Subject;

@Repository
public class SubjectDaoImpl implements SubjectDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Subject> getAllSubjects() {
		String jpql = "SELECT s FROM Subject s";
		return sf.getCurrentSession().createQuery(jpql, Subject.class).getResultList();
	}

	@Override
	public String addSubject(Subject subject) {
		sf.getCurrentSession().save(subject);
		return "Subject added successfully.";
	}

	@Override
	public String removeSubject(Subject subject) {
		sf.getCurrentSession().delete(subject);
		return "Subject deleted successfully.";
	}

}
