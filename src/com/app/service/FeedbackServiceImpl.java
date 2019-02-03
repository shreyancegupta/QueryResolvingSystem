package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.FeedbackDao;
import com.app.pojos.Feedback;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackDao dao;
	
	@Override
	public String addFeedBack(Feedback feedBack) {
		return dao.saveFeedBack(feedBack);
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		return dao.getAllFeedbacks();
	}
}
