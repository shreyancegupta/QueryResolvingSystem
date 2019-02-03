package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Feedback;
import com.app.service.FeedbackService;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	private FeedbackService service;
	
	@GetMapping("/addFeedBack")
	public String postFeedBack(@RequestParam String name,@RequestParam String email,@RequestParam String feedBack, RedirectAttributes flashMap)
	{
		Feedback f=new Feedback(name,email,feedBack);
		String s=service.addFeedBack(f);
		flashMap.addFlashAttribute("status", s);
		return "redirect:/";
	}
	
}
