package com.app.dao;

import java.util.List;

import com.app.pojos.Question;
import com.app.pojos.Reply;
import com.app.pojos.Student;
import com.app.pojos.Teacher;

public interface ReplyDao {
	String addReply(Reply reply);
	List<Reply> getRepliesByQuestion(Question q);
	List<Question> getRepliedQuestionsByTeacher(Teacher teacher);
	List<Question> getSubjectWiseRepliedQuestionsByTeacher(Teacher teacher, String subject);
	String nullifyRepliedStudent(Student s);
	String nullifyRepliedTeacher(Teacher t);
}
