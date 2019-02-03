package com.app.service;

import java.util.List;

import com.app.pojos.Question;
import com.app.pojos.Reply;

public interface ReplyService {
	String addReplyToQuestion(Reply reply);
	//List<Reply> getRepliesByQuestion(Question q);
	List<Reply> getRepliesByTime(Question q);
}
