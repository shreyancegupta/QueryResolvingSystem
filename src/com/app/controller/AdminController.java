package com.app.controller;

import static com.app.utils.RoleVerifier.validateUser;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Student;
import com.app.pojos.Subject;
import com.app.pojos.Teacher;
import com.app.service.AdminService;
import com.app.service.FeedbackService;
import com.app.service.SubjectService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private FeedbackService feedbackService;
	
	@Autowired
	private JavaMailSender sender;
	
	@GetMapping("/home")
	public String showAdminHomePage(HttpSession hs){
		String str = validateUser(hs, "admin");
		if(!str.equals("true"))
			return str;
		return "/admin/home";
	}
	
	@GetMapping("/add_student")
	public String showAddStudentForm(Student student, HttpSession hs) {
		String str = validateUser(hs, "admin");
		if(!str.equals("true"))
			return str;
		return "/admin/add_student";
	}
	
	@PostMapping("/add_student")
	public String processAddStudentForm(Student student, RedirectAttributes flashMap) {
		flashMap.addFlashAttribute("status", adminService.addStudent(student));
		return "redirect:/admin/home";
	}
	
//	public String removeStudent() {
//		return null;
//	}
	
	@GetMapping("/add_teacher")
	public String showAddTeacherForm(Teacher teacher, HttpSession hs, RedirectAttributes flashMap) {
		String str = validateUser(hs, "admin");
		if(!str.equals("true"))
			return str;
		List<String> subjects = subjectService.getSubjectList();
		if (!subjects.isEmpty()) {
			hs.setAttribute("subjectList", subjects);
			return "/admin/add_teacher";
		} else {
			flashMap.addFlashAttribute("status", "Please add at least one subject before adding teachers");
			return "redirect:/admin/home";
		}
		
	}
	
	@PostMapping("/add_teacher")
	public String processAddTeacherForm(Teacher teacher, RedirectAttributes flashMap) {
		flashMap.addFlashAttribute("status", adminService.addTeacher(teacher));
		return "redirect:/admin/home";
	}
	

	
	@GetMapping("/add_subject")
	public String showAddSubjectForm(Subject subject, HttpSession hs) {
		String str = validateUser(hs, "admin");
		if(!str.equals("true"))
			return str;
		return "/admin/add_subject";
	}
	
	@PostMapping("/add_subject")
	public String processAddSubjectForm(Subject subject, RedirectAttributes flashMap) {
		flashMap.addFlashAttribute("status", adminService.addSubject(subject));
		return "redirect:/admin/home";
	}
	
//	public String removeSubject() {
//		return null;
//	}
	
	@GetMapping("/logout")
	public String processAdminLogout(HttpSession hs/*, RedirectAttributes flashMap*/) {
		String str = validateUser(hs, "admin");
		if(!str.equals("true"))
			return str;
		//flashMap.addFlashAttribute("user", hs.getAttribute("user"));
		hs.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/list_remove")
	public String showList(@RequestParam String entity, Model map, HttpSession hs) {
		String str = validateUser(hs, "admin");
		if(!str.equals("true"))
			return str;
		switch (entity) {
		case "students":
			map.addAttribute("entityList", adminService.getAllStudents());
			hs.setAttribute("entityType", "student");
			break;
			
		case "teachers":
			map.addAttribute("entityList", adminService.getAllTeachers());
			hs.setAttribute("entityType", "teacher");
			break;
			
		case "subjects":
			map.addAttribute("entityList", adminService.getAllSubjects());
			hs.setAttribute("entityType", "subject");
			break;
			
		default:
			return "/error_page";
		}
		return "/admin/list_remove";
	}
	
	@GetMapping("/remove_entity")
	public String processDeletion(@RequestParam int id, HttpSession hs, RedirectAttributes flashMap) {
		String str = validateUser(hs, "admin");
		if(!str.equals("true"))
			return str;
		String entityType = (String) hs.getAttribute("entityType");
		switch (entityType) {
		case "student":
			Student s = new Student(id);
			flashMap.addFlashAttribute("status", adminService.removeStudent(s));
			break;
			
		case "teacher":
			flashMap.addFlashAttribute("status", adminService.removeTeacher(new Teacher(id)));
			break;
			
		case "subject":
			flashMap.addFlashAttribute("status", adminService.removeSubject(new Subject(id)));
			break;

		default:
			break;
		}
		return "redirect:/admin/list_remove?entity=" + entityType + "s";
	}
	
	@GetMapping("/update_student")
	public String showStudentUpdateForm(@RequestParam int id, HttpSession hs, Model map) {
		String str = validateUser(hs, "admin");
		if(!str.equals("true"))
			return str;
		map.addAttribute("student", adminService.getStudentById(id));
		return "/admin/update_student";
	}
	
	@PostMapping("/update_student")
	public String processStudentUpdateForm(HttpSession hs, Model map, Student student) {
		map.addAttribute("status", adminService.updateStudent(student));
		String entityType = (String) hs.getAttribute("entityType");
		return "redirect:/admin/list_remove?entity=" + entityType + "s";
	}
	
	@GetMapping("/update_teacher")
	public String showTeacherUpdateForm(@RequestParam int id, HttpSession hs, Model map) {
		String str = validateUser(hs, "admin");
		if(!str.equals("true"))
			return str;
		map.addAttribute("teacher", adminService.getTeacherById(id));
		return "/admin/update_teacher";
	}
	
	@PostMapping("/update_teacher")
	public String processTeacherUpdateForm(HttpSession hs, Model map, Teacher teacher) {
		//System.out.println("================\n"+teacher+"\n===============");
		map.addAttribute("status", adminService.updateTeacher(teacher));
		String entityType = (String) hs.getAttribute("entityType");
		return "redirect:/admin/list_remove?entity=" + entityType + "s";
	}
	
	@GetMapping("/show_feedbacks")
	public String showFeedbacks(Model map) {
		map.addAttribute("feedbacks", feedbackService.getAllFeedbacks());
		return "/admin/list_feedbacks";
	}
	
	@GetMapping("/email")
	public String sendEmail(HttpSession hs, @RequestParam String emailId) {
		SimpleMailMessage mesg=new SimpleMailMessage();
		mesg.setTo(emailId);
		mesg.setSubject("WBQRS: Password Reset");
		mesg.setText("Your password has been reset successfully.\nNew password is: password");
		sender.send(mesg);
		String entityType = (String) hs.getAttribute("entityType");
		return "redirect:/admin/list_remove?entity=" + entityType + "s";
	}
}
	