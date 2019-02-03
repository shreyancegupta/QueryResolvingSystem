package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.SubjectDao;
import com.app.pojos.Subject;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDao dao;
	
	@Override
	public List<String> getSubjectList() {
		List<String> subjects = new ArrayList<>();
		for(Subject s : dao.getAllSubjects())
			subjects.add(s.getName());
		return subjects;
	}

}
