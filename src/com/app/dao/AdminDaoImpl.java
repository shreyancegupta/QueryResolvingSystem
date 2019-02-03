package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Admin;
import com.app.pojos.Student;
import com.app.pojos.Subject;
import com.app.pojos.Teacher;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Admin retrieveAdmin(String username, String password) {
		String jpql = "SELECT a FROM Admin a WHERE a.name=:un AND a.password=:pass";
		
		return sf.getCurrentSession().createQuery(jpql, Admin.class).setParameter("un", username).setParameter("pass", password).getSingleResult();
	}

}
