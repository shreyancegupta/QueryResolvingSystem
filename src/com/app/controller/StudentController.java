package com.app.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Question;
import com.app.pojos.Reply;
import com.app.pojos.Student;
import com.app.service.QuestionService;
import com.app.service.ReplyService;
import com.app.service.StudentService;
import com.app.service.SubjectService;

import static com.app.utils.SecurityUtils.*;
import static com.app.utils.RoleVerifier.*;
@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private ReplyService replyService;
	
	@GetMapping("/home")
	public String showStudentHomePage(HttpSession hs, @RequestParam String filterSubject, @RequestParam String dateTimeOrder){
		//Stream<Question> feed = studentService.showFeed().stream().filter((q)->q.equals(filterSubject)).sorted((Question q1, Question q2)->{return q2.getDate().compareTo(q1.getDate());});
		String str = validateUser(hs, "student");
		if(!str.equals("true"))
			return str;
		List<Question> feed = studentService.showSubjectWiseFeed(filterSubject);
		if(dateTimeOrder.equals("desc")) {
			feed.sort((Question q1, Question q2)->{return q2.getDate().compareTo(q1.getDate());});
		}
		if(dateTimeOrder.equals("asc")) {
			feed.sort((Question q1, Question q2)->{return q1.getDate().compareTo(q2.getDate());});
		}
		hs.setAttribute("studentFeed", feed);
		hs.setAttribute("subjects", subjectService.getSubjectList());
		return "/student/home";
	}
	
	@GetMapping("/post_question")
	public String showPostQuestionForm(Question question, HttpSession hs) {
//		hs.setAttribute("subjects", subjectService.getSubjectList());
		String str = validateUser(hs, "student");
		if(!str.equals("true"))
			return str;
		return "/student/post_question";
	}
	
	@PostMapping("/post_question")
	public String processPostQuestionForm(Question question, HttpSession hs, RedirectAttributes flashMap) {
		question.setStudentId(((Student)hs.getAttribute("user")).getId());
		question.setDate(new Date());
		question.setClosed(false);
		flashMap.addFlashAttribute("status", studentService.postQuestion(question));
		System.out.println(question);
		return "redirect:/student/home?filterSubject=none&dateTimeOrder=desc";
	}
	
//	public String showFeed() {
//		return null;
//	}
	
	@GetMapping("/my_questions")
	public String showMyAskedQuestions(Model map, HttpSession hs, @RequestParam String filterSubject, @RequestParam String dateTimeOrder) {
		String str = validateUser(hs, "student");
		if(!str.equals("true"))
			return str;
		Student s = (Student) hs.getAttribute("user");
		List<Question> myQuestions = studentService.showSubjectWiseMyAskedQuestions(s.getId(), filterSubject);
		if(dateTimeOrder.equals("desc")) {
			myQuestions.sort((Question q1, Question q2)->{return q2.getDate().compareTo(q1.getDate());});
		}if(dateTimeOrder.equals("asc")) {
			myQuestions.sort((Question q1, Question q2)->{return q1.getDate().compareTo(q2.getDate());});
		}
		map.addAttribute("myQuestions", myQuestions);
		return "/student/my_questions";
	}
	
	@GetMapping("/discussion")
	public String showAddReplyForm(Reply reply, @RequestParam int qid, HttpSession hs) {
		String str = validateUser(hs, "student");
		if(!str.equals("true"))
			return str;
//		Reply reply = new Reply();
//		map.addAttribute(reply);
		Question q = questionService.getQuestionById(qid);
		hs.setAttribute("question", q);
		//System.out.println(hs.getAttribute("question"));
//		hs.setAttribute("replies", replyService.getRepliesByQuestion(q));
		hs.setAttribute("replies", replyService.getRepliesByTime(q));
		//System.out.println(hs.getAttribute("replies"));
		return "/discussion";
	}
	
	@PostMapping("/discussion")
	public String processAddReplyForm(Reply reply, HttpSession hs) {
		reply.setDate(new Date());
		Question q = (Question) hs.getAttribute("question");
		q.addReply(reply);
		 
		//reply.setQuestion(q); done in convenience method of question pojo
		int qid = q.getId();
		reply.setStudent((Student)hs.getAttribute("user"));
		replyService.addReplyToQuestion(reply);
		return "redirect:/student/discussion?qid=" + qid;
	}
	
	@GetMapping("close_question")
	public String closeTheQuestion(@RequestParam int qid, HttpSession hs) {
		String str = validateUser(hs, "student");
		if(!str.equals("true"))
			return str;
		studentService.closeTheQuestion((Question) hs.getAttribute("question"));
		return "redirect:/student/discussion?qid=" + qid;
	}
	
	@GetMapping("/logout")
	public String processStudentLogout(HttpSession hs/*, RedirectAttributes flashMap*/) {
		//flashMap.addFlashAttribute("user", hs.getAttribute("user"));
		hs.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String showUpdateForm(Model map, HttpSession hs, @RequestParam String toUpdate) {
		String str = validateUser(hs, "student");
		if(!str.equals("true"))
			return str;
		hs.setAttribute("toUpdate", toUpdate);
		map.addAttribute("student",(Student)hs.getAttribute("user"));
		return "/student/update_student";
	}
	
	@PostMapping("/update")
	public String processUpdateForm(Student student, RedirectAttributes flashMap, HttpSession hs) {
		if(hs.getAttribute("toUpdate").equals("profile"))
			student.setPassword((String)hs.getAttribute("password"));
		flashMap.addFlashAttribute("status", studentService.updateStudent(student));
		hs.setAttribute("user", student);
		return "redirect:/student/home?filterSubject=none&dateTimeOrder=desc";
	}
}
