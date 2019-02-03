package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.QuestionDao;
import com.app.pojos.Question;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDao dao;

	@Override
	public Question getQuestionById(int id) {
		return dao.getQuestionById(id);
	}

}
