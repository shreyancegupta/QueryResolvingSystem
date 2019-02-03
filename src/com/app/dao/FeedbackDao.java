package com.app.dao;

import java.util.List;

import com.app.pojos.Feedback;

public interface FeedbackDao {

	public String saveFeedBack(Feedback feedback);
	public List<Feedback> getAllFeedbacks();
}
