package com.app.controller;

import static com.app.utils.RoleVerifier.validateUser;

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
import com.app.pojos.Teacher;
import com.app.service.QuestionService;
import com.app.service.ReplyService;
import com.app.service.SubjectService;
import com.app.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private SubjectService subjectService;
	
	@GetMapping("/home")
	public String showTeacherHomePage(HttpSession hs, @RequestParam String filterSubject, @RequestParam String dateTimeOrder){
		String str = validateUser(hs, "teacher");
		if(!str.equals("true"))
			return str;
		List<Question> feed = teacherService.getSubjectWiseOpenQuestions(filterSubject);
		if(dateTimeOrder.equals("desc")) {
			feed.sort((Question q1, Question q2)->{return q2.getDate().compareTo(q1.getDate());});
		}
		if(dateTimeOrder.equals("asc")) {
			feed.sort((Question q1, Question q2)->{return q1.getDate().compareTo(q2.getDate());});
		}
		hs.setAttribute("teacherFeed", feed);
		hs.setAttribute("subjects", subjectService.getSubjectList());
		return "/teacher/home";
	}
	
//	public String showNewQuestions() {
//		return null;
//	}
	
	@GetMapping("/my_replied_questions")
	public String showMyRepliedQuestions(Model map, HttpSession hs, @RequestParam String filterSubject, @RequestParam String dateTimeOrder) {
		String str = validateUser(hs, "teacher");
		if(!str.equals("true"))
			return str;
		//Teacher t = (Teacher) hs.getAttribute("user");
		List<Question> myRepliedQuestions = teacherService.showSubjectWiseQuestionsWithMyReplies((Teacher) hs.getAttribute("user"), filterSubject);
		if(dateTimeOrder.equals("desc")) {
			myRepliedQuestions.sort((Question q1, Question q2)->{return q2.getDate().compareTo(q1.getDate());});
		}
		if(dateTimeOrder.equals("asc")) {
			myRepliedQuestions.sort((Question q1, Question q2)->{return q1.getDate().compareTo(q2.getDate());});
		}
		map.addAttribute("myRepliedQuestions", myRepliedQuestions);
		return "/teacher/my_replied_questions";
	}
	
	@GetMapping("/discussion")
	public String showAddReplyForm(Reply reply, @RequestParam int qid, HttpSession hs) {
		String str = validateUser(hs, "teacher");
		if(!str.equals("true"))
			return str;
//		Reply reply = new Reply();
//		map.addAttribute(reply);
		Question q = questionService.getQuestionById(qid);
		hs.setAttribute("question", q);
		//System.out.println(hs.getAttribute("question"));
		//hs.setAttribute("replies", replyService.getRepliesByQuestion(q));
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
		reply.setTeacher((Teacher)hs.getAttribute("user"));
		replyService.addReplyToQuestion(reply);
		return "redirect:/teacher/discussion?qid=" + qid;
	}
		
	@GetMapping("/logout")
	public String processTeacherLogout(HttpSession hs/*, RedirectAttributes flashMap*/) {
		//flashMap.addFlashAttribute("user", hs.getAttribute("user"));
		hs.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String showUpdateForm(Model map, HttpSession hs, @RequestParam String toUpdate) {
		String str = validateUser(hs, "teacher");
		if(!str.equals("true"))
			return str;
		hs.setAttribute("toUpdate", toUpdate);
		map.addAttribute("teacher",(Teacher)hs.getAttribute("user"));
		return "/teacher/update_teacher";
	}
	
	@PostMapping("/update")
	public String processUpdateForm(Teacher teacher, RedirectAttributes flashMap, HttpSession hs) {
		if(hs.getAttribute("toUpdate").equals("profile"))
			teacher.setPassword((String)hs.getAttribute("password"));
		flashMap.addFlashAttribute("status", teacherService.updateTeacher(teacher));
		hs.setAttribute("user", teacher);
		return "redirect:/teacher/home?filterSubject="+ teacher.getSubject() +"&dateTimeOrder=desc";
	}
}
