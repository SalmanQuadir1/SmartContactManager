package com.SmartContactManager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SmartContactManager.dao.UserRepository;
import com.SmartContactManager.entities.Contact;
import com.SmartContactManager.entities.User;

@Controller
public class HomeController {
	@Autowired
	private UserRepository userrepo;

	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		User user = new User();
		user.setName("Salman");
		Contact cont=new Contact();
		cont.setDescription("desc");
		cont.setEmail("email@gmail.com");
		cont.setPhone("7006584939");
		user.setEmail("email@gmail.com");
		cont.setUser(user);
		List<Contact> contt=List.of(cont);
		user.setContact(contt);
		userrepo.save(user);

		return "Working...";
	}

}
