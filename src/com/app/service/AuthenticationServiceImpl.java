package com.app.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AdminDao;
import com.app.dao.StudentDao;
import com.app.dao.TeacherDao;
import com.app.utils.*;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private TeacherDao teacherDao;
	
	@Autowired
	private AdminDao adminDao;
	
	@Override
	public Object retrieveUser(String username, String password, String role) {
		Object o = null;
		String s = new String(SecurityUtils.getHash(password)); 
		try{
			switch(role) {
				case "student":
					o = studentDao.retrieveStudent(username, s);
					break;
				case "teacher":
					o = teacherDao.retrieveTeacher(username, s);
					break;
				case "admin":
					o = adminDao.retrieveAdmin(username, password);
					break;
			}
		return o;
		} catch (NoResultException e) {
			System.out.println("Invalid Login.");
			return null;
		}
	}

}
