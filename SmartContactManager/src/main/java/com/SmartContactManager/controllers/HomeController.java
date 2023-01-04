package com.SmartContactManager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SmartContactManager.dao.UserRepository;
import com.SmartContactManager.entities.Contact;
import com.SmartContactManager.entities.User;

@Controller
public class HomeController {
	@Autowired
	private UserRepository userrepo;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/home")
	public String test(Model model) {
		User user = new User();
		user.setName("Salman");
		Contact cont = new Contact();
		cont.setDescription("desc");
		cont.setEmail("email@gmail.com");
		cont.setPhone("7006584939");
		user.setEmail("email@gmail.com");
		cont.setUser(user);
		List<Contact> contt = List.of(cont);
		user.setContact(contt);
		userrepo.save(user);
		model.addAttribute("user", user);

		return "views/home";
	}

	
	@RequestMapping("/register")
	public String Signup() {
		
		return "views/signup";
	}

}
