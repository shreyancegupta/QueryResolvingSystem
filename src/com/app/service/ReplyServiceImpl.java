package com.app.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ReplyDao;
import com.app.pojos.Question;
import com.app.pojos.Reply;

@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDao dao;
	
	@Override
	public String addReplyToQuestion(Reply reply) {
		return dao.addReply(reply);
	}

	@Override
	public List<Reply> getRepliesByTime(Question q) {
		List<Reply> replies = q.getReplies();
		Collections.sort(replies, (Reply r1, Reply r2) -> r1.getDate().compareTo(r2.getDate()));
		return replies;
	}

//	@Override
//	public List<Reply> getRepliesByQuestion(Question q) {
//		return dao.getRepliesByQuestion(q);
//	}
	
	

}
