package com.app.dao;

import com.app.pojos.Admin;
import com.app.pojos.Student;
import com.app.pojos.Subject;
import com.app.pojos.Teacher;

public interface AdminDao {
	Admin retrieveAdmin(String username, String password);
}
