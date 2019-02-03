package com.app.service;

import java.util.List;

import com.app.pojos.Question;
import com.app.pojos.Reply;
import com.app.pojos.Student;

public interface StudentService {
	String postQuestion(Question q);
	List<Question> showFeed();
	List<Question> showSubjectWiseFeed(String subject);
	List<Question> showMyAskedQuestions(int sid);
	List<Question> showSubjectWiseMyAskedQuestions(int sid, String subject);
	String closeTheQuestion(Question q);
	//String addReplyToQuestion(Reply reply, int qid);
	String updateStudent(Student student);
}
