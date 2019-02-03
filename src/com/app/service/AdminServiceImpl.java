package com.app.service;

import static com.app.utils.SecurityUtils.getHash;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AdminDao;
import com.app.dao.ReplyDao;
import com.app.dao.StudentDao;
import com.app.dao.SubjectDao;
import com.app.dao.TeacherDao;
import com.app.pojos.Student;
import com.app.pojos.Subject;
import com.app.pojos.Teacher;
import com.app.utils.SecurityUtils;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private TeacherDao teacherDao;
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private SubjectDao subjectDao;
	
	@Autowired
	private ReplyDao replyDao;
	
	@Override
	public String addStudent(Student student) {
		String s = student.getPassword();
		byte[] b = SecurityUtils.getHash(s);
		student.setPassword(new String(b));
		return studentDao.addStudent(student);
	}

	@Override
	public String removeStudent(Student student) {
		replyDao.nullifyRepliedStudent(student);
		return studentDao.removeStudent(student);
	}
	
	@Override
	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);
	}
	
	@Override
	public String updateStudent(Student student) {
		student.setPassword(new String(SecurityUtils.getHash(student.getPassword())));
		return studentDao.updateStudent(student);
	}

	@Override
	public String addTeacher(Teacher teacher) {
		String s = teacher.getPassword();
		byte[] b = SecurityUtils.getHash(s);
		teacher.setPassword(new String(b));
		return teacherDao.addTeacher(teacher);
	}

	@Override
	public String removeTeacher(Teacher teacher) {
		replyDao.nullifyRepliedTeacher(teacher);
		return teacherDao.removeTeacher(teacher);
	}

	@Override
	public Teacher getTeacherById(int id) {
		return teacherDao.getTeacherById(id);
	}
	
	@Override
	public String updateTeacher(Teacher teacher) {
		teacher.setPassword(new String(SecurityUtils.getHash(teacher.getPassword())));
		return teacherDao.updateTeacher(teacher);
	}
	
	@Override
	public String addSubject(Subject subject) {
		return subjectDao.addSubject(subject);
	}

	@Override
	public String removeSubject(Subject subject) {
		return subjectDao.removeSubject(subject);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	@Override
	public List<Teacher> getAllTeachers() {
		return teacherDao.getAllTeachers();
	}

	@Override
	public List<Subject> getAllSubjects() {
		return subjectDao.getAllSubjects();
	}

	@Override
	public String updatePassword(Object object, String password) {
		if(object instanceof Student){
			Student student = (Student) object;
			student.setPassword(new String(getHash(password)));
			studentDao.updateStudent(student);
			return "redirect:/student/home?filterSubject=none&dateTimeOrder=desc";
		}
		else if(object instanceof Teacher){
			Teacher teacher = (Teacher) object;
			teacher.setPassword(new String(getHash(password)));
			teacherDao.updateTeacher(teacher);
			return "redirect:/teacher/home?filterSubject=" + ((Teacher)object).getSubject() + "&dateTimeOrder=desc";
		}
		return "redirect:/authenticate/error";
	}

}
