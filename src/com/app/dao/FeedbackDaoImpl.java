package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Feedback;

@Repository
public class FeedbackDaoImpl implements FeedbackDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public String saveFeedBack(Feedback feedback) {
		sf.getCurrentSession().save(feedback);
		return "Feedback Added Successfully";
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		String jpql = "SELECT f FROM Feedback f";
		return sf.getCurrentSession().createQuery(jpql, Feedback.class).getResultList();
	}

}
