package com.app.dao;

import java.util.List;

import com.app.pojos.Question;

public interface QuestionDao {
	String addQuestion(Question q);
	List<Question> getAllQuestions();
	List<Question> getSubjectWiseQuestions(String subject);
	List<Question> getQuestionsByStudentId(int id);
	List<Question> getSubjectWiseQuestionsByStudentId(int id, String subject);
	List<Question> getNewQuestions();
	List<Question> getOpenQuestions();
	List<Question> getSubjectWiseOpenQuestions(String subject);
	String closeTheQuestion(Question q);
	Question getQuestionById(int id);
}
