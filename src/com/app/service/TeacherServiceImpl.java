package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.QuestionDao;
import com.app.dao.ReplyDao;
import com.app.dao.TeacherDao;
import com.app.pojos.Question;
import com.app.pojos.Teacher;
import com.app.utils.SecurityUtils;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private QuestionDao qDao;
	
	@Autowired
	private ReplyDao rDao;
	
	@Autowired
	private TeacherDao tDao;
	
	//Unused
	@Override
	public List<Question> showNewQuestions() {
		return qDao.getNewQuestions();
	}

	@Override
	public List<Question> showQuestionsWithMyReplies(Teacher teacher) {
		return rDao.getRepliedQuestionsByTeacher(teacher);
	}

	@Override
	public List<Question> getOpenQuestions() {
		return qDao.getOpenQuestions();
	}

	@Override
	public List<Question> getSubjectWiseOpenQuestions(String subject) {
		if(subject.equals("none"))
			return qDao.getOpenQuestions();
		return qDao.getSubjectWiseOpenQuestions(subject);
	}

	@Override
	public List<Question> showSubjectWiseQuestionsWithMyReplies(Teacher teacher, String subject) {
		if(subject.equals("none"))
			return rDao.getRepliedQuestionsByTeacher(teacher);
		return rDao.getSubjectWiseRepliedQuestionsByTeacher(teacher, subject);
	}
	
	@Override
	public String updateTeacher(Teacher teacher) {
		teacher.setPassword(new String(SecurityUtils.getHash(teacher.getPassword())));
		return tDao.updateTeacher(teacher);
	}

}
