package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Question;
import com.app.pojos.Reply;
import com.app.pojos.Student;
import com.app.pojos.Teacher;

@Repository
public class ReplyDaoImpl implements ReplyDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public String addReply(Reply reply) {
		sf.getCurrentSession().save(reply);
		return "Reply added successfully";
	}

	@Override
	public List<Reply> getRepliesByQuestion(Question q) {
		String jpql = "SELECT r FROM Reply r WHERE r.question=:q";
		return sf.getCurrentSession().createQuery(jpql, Reply.class).setParameter("q", q).getResultList();
	}

	@Override
	public List<Question> getRepliedQuestionsByTeacher(Teacher teacher) {
		String jpql = "SELECT q FROM Question q WHERE q IN (SELECT r.question FROM Reply r WHERE r.teacher=:t)";
		//String jpql = "SELECT q FROM Question q INNER JOIN Reply r ON q=r.question AND r.teacher=:t"; NOT WORKING!!!
		return sf.getCurrentSession().createQuery(jpql, Question.class).setParameter("t", teacher).getResultList();
	}

	@Override
	public List<Question> getSubjectWiseRepliedQuestionsByTeacher(Teacher teacher, String subject) {
		String jpql = "SELECT q FROM Question q WHERE q IN (SELECT r.question FROM Reply r WHERE r.teacher=:t) AND q.subject=:sub";
		return sf.getCurrentSession().createQuery(jpql, Question.class).setParameter("t", teacher).setParameter("sub", subject).getResultList();
	}

	@Override
	public String nullifyRepliedStudent(Student s) {
		String jpql = "UPDATE Reply r SET r.student=null WHERE r.student=:stud";
		sf.getCurrentSession().createQuery(jpql).setParameter("stud", s).executeUpdate();
		return "success";
	}
	
	@Override
	public String nullifyRepliedTeacher(Teacher t) {
		String jpql = "UPDATE Reply r SET r.teacher=null WHERE r.teacher=:teacher";
		sf.getCurrentSession().createQuery(jpql).setParameter("teacher", t).executeUpdate();
		return "success";
	}

}
