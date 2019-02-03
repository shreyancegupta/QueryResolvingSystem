package com.app.service;

import java.util.List;

import com.app.pojos.Question;
import com.app.pojos.Teacher;

public interface TeacherService {
	List<Question> showNewQuestions();
	List<Question> getOpenQuestions();
	List<Question> getSubjectWiseOpenQuestions(String subject);
	List<Question> showQuestionsWithMyReplies(Teacher teacher);
	List<Question> showSubjectWiseQuestionsWithMyReplies(Teacher teacher, String subject);
	String updateTeacher(Teacher teacher);
}
