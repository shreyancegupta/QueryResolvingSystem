package com.app.utils;

import javax.servlet.http.HttpSession;

import com.app.pojos.Admin;
import com.app.pojos.Student;
import com.app.pojos.Teacher;

public class RoleVerifier
{
	public static String validateUser(HttpSession hs, String role)
	{
		if(hs.getAttribute("user")==null)
			return "redirect:/";
		
		if(hs.getAttribute("role").equals(role))
			return "true";
		
		Object o = hs.getAttribute("user");
		
		if(o instanceof Student)
			return "redirect:/student/home?filterSubject=none&dateTimeOrder=desc";
		if(o instanceof Teacher)
			return "redirect:/teacher/home?filterSubject="+ ((Teacher)o).getSubject() +"&dateTimeOrder=desc";
		if(o instanceof Admin)
			return "redirect:/admin/home";
		return "redirect:/";
	}
	
	public static String authVerifier(HttpSession hs) {
		if(hs.getAttribute("user")==null)
			return "true";
		
		Object o = hs.getAttribute("user");
		
		if(o instanceof Student)
			return "redirect:/student/home?filterSubject=none&dateTimeOrder=desc";
		if(o instanceof Teacher)
			return "redirect:/teacher/home?filterSubject="+ ((Teacher)o).getSubject() +"&dateTimeOrder=desc";
		if(o instanceof Admin)
			return "redirect:/admin/home";
		return "redirect:/";
	}
}