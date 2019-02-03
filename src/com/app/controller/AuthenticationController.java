package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Admin;
import com.app.pojos.Student;
import com.app.pojos.Teacher;
import com.app.service.AdminService;
import com.app.service.AuthenticationService;

import static com.app.utils.SecurityUtils.*;
import static com.app.utils.RoleVerifier.*;

@Controller
@RequestMapping("/authenticate")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authService;
	
	@Autowired
	private AdminService adminService;

	@GetMapping("/user")
	public String sendLoginForm(HttpSession hs) {
		String str = authVerifier(hs);
		if(!str.equals("true"))
			return str;
		return "/login";
	}
	
	@PostMapping("/user")
	public String authenticateUser(@RequestParam String username, @RequestParam String password, @RequestParam String role, HttpSession hs, Model map) {
		Object object = authService.retrieveUser(username, password, role);
		hs.setAttribute("user",object);
		if(object instanceof Student)
		{
			hs.setAttribute("role", "student");
			if(password.equals("password")) {
				map.addAttribute("uname", username);
				return "/first_login";
			}
			hs.setAttribute("password", password);
			return "redirect:/student/home?filterSubject=none&dateTimeOrder=desc";
		}
		else if(object instanceof Teacher)
		{
			hs.setAttribute("role", "teacher");
			if(password.equals("password")) {
				map.addAttribute("uname", username);
				return "/first_login";
			}
			hs.setAttribute("password", password);
			return "redirect:/teacher/home?filterSubject=" + ((Teacher)object).getSubject() + "&dateTimeOrder=desc";
		}
		else if(object instanceof Admin)
		{
			hs.setAttribute("role", "admin");
			return "redirect:/admin/home";
		}
		return "redirect:/authenticate/error";
	}
	
	@GetMapping("/error")
	public String sendErrorPage() {
		return "/error_page";
	}
	
	@PostMapping("/update_password")
	public String updatePassword(@RequestParam String username, @RequestParam String password, @RequestParam String role, Model map, HttpSession hs) {
		if(password.equals("password")) {
			map.addAttribute("uname", username);
			return "/first_login";
		}
		return adminService.updatePassword(hs.getAttribute("user"), password);
	}
}
