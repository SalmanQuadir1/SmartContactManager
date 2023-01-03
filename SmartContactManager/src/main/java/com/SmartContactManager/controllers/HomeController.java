package com.SmartContactManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SmartContactManager.dao.UserRepository;
import com.SmartContactManager.entities.User;

@Controller
public class HomeController {
	@Autowired
	private UserRepository userrepo;
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		User user=new User();
		user.setName("Salman");
		user.setEmail("najarsalman4@gmail.com");
		userrepo.save(user);
		
		return "Working...";
	}
	
}
