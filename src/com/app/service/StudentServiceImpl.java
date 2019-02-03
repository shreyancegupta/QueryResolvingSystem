package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.QuestionDao;
import com.app.dao.ReplyDao;
import com.app.dao.StudentDao;
import com.app.pojos.Question;
import com.app.pojos.Student;
import com.app.utils.SecurityUtils;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private QuestionDao qDao;
	
	@Autowired
	private ReplyDao rDao;
	
	@Autowired
	private StudentDao sDao;
	
	@Override
	public String postQuestion(Question q) {
		return qDao.addQuestion(q);
	}

	//UNUSED
	@Override
	public List<Question> showFeed() {
		return qDao.getAllQuestions();
	}
	
	@Override
	public List<Question> showSubjectWiseFeed(String subject) {
		if(subject.equals("none"))
			return qDao.getAllQuestions();
		return qDao.getSubjectWiseQuestions(subject);
	}
	
	@Override
	public List<Question> showMyAskedQuestions(int sid) {
		return qDao.getQuestionsByStudentId(sid);
	}
	
	@Override
	public List<Question> showSubjectWiseMyAskedQuestions(int sid, String subject) {
		if(subject.equals("none"))
			return qDao.getQuestionsByStudentId(sid);
		return qDao.getSubjectWiseQuestionsByStudentId(sid, subject);
	}

	@Override
	public String closeTheQuestion(Question q) {
		q.setClosed(true);
		return qDao.closeTheQuestion(q);
	}
	
	@Override
	public String updateStudent(Student student) {
		student.setPassword(new String(SecurityUtils.getHash(student.getPassword())));
		return sDao.updateStudent(student);
	}

}
