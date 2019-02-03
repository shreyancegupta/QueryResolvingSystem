package com.app.service;

import java.util.List;

import com.app.pojos.Feedback;

public interface FeedbackService {

	public String addFeedBack(Feedback f);
	public List<Feedback> getAllFeedbacks();
}
