package com.app.dao;

import java.util.List;

import com.app.pojos.Subject;

public interface SubjectDao {
	String addSubject(Subject subject);
	String removeSubject(Subject subject);
	List<Subject> getAllSubjects();
}
