package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Question;

@Repository
public class QuestionDaoImpl implements QuestionDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public String addQuestion(Question q) {
		sf.getCurrentSession().save(q);
		return "Question posted successfully.";
	}

	
	//Should we show only questions having replies or all questions w/o having replies too?
	@Override
	public List<Question> getAllQuestions() {
		String jpql = "SELECT q FROM Question q";
		return sf.getCurrentSession().createQuery(jpql, Question.class).getResultList();
	}
	
	@Override
	public List<Question> getSubjectWiseQuestions(String subject) {
		String jpql = "SELECT q FROM Question q WHERE q.subject=:sub";
		return sf.getCurrentSession().createQuery(jpql, Question.class).setParameter("sub", subject).getResultList();
	}

	@Override
	public List<Question> getQuestionsByStudentId(int id) {
		String jpql = "SELECT q FROM Question q WHERE q.studentId=:id";
		return sf.getCurrentSession().createQuery(jpql, Question.class).setParameter("id", id).getResultList();
	}
	
	@Override
	public List<Question> getSubjectWiseQuestionsByStudentId(int id, String subject) {
		String jpql = "SELECT q FROM Question q WHERE q.studentId=:id AND q.subject=:sub";
		return sf.getCurrentSession().createQuery(jpql, Question.class).setParameter("id", id).setParameter("sub", subject).getResultList();
	}

	@Override
	public List<Question> getNewQuestions() {
		String jpql = "SELECT q FROM Question q WHERE q NOT IN (SELECT r.question FROM Reply r)";
		return sf.getCurrentSession().createQuery(jpql, Question.class).getResultList();
	}

	@Override
	public List<Question> getOpenQuestions() {
		String jpql = "SELECT q FROM Question q WHERE q.closed=:bool";
		return sf.getCurrentSession().createQuery(jpql, Question.class).setParameter("bool", false).getResultList();
	}

	@Override
	public List<Question> getSubjectWiseOpenQuestions(String subject) {
		String jpql = "SELECT q FROM Question q WHERE q.closed=:bool AND q.subject=:sub";
		return sf.getCurrentSession().createQuery(jpql, Question.class).setParameter("bool", false).setParameter("sub", subject).getResultList();
	}

	@Override
	public String closeTheQuestion(Question q) {
		sf.getCurrentSession().update(q);
		return "Question closed successfully";
	}
	
	@Override
	public Question getQuestionById(int id) {
		return sf.getCurrentSession().get(Question.class, id);
	}

}
