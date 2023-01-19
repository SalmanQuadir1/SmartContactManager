package com.SmartContactManager.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SmartContactManager.dao.UserRepository;
import com.SmartContactManager.entities.Contact;
import com.SmartContactManager.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired 
	UserRepository userrepo;
	@ModelAttribute
	public void addCommonData( Model m,Principal principal) {
		String UserName=principal.getName();
		System.err.println(UserName);
		User usr=userrepo.getUserByUserName(UserName);
		System.err.println(usr);
		m.addAttribute("user", usr);
	}
	@RequestMapping("/index")
	public String dashboard(Model model,Principal principal) {
		
		return "views/user_dashboard";
	}
	
	//add form Controller
	@GetMapping("/add-contact")
	public String openAddContactForm(Model model) {
		model.addAttribute("title","Add Contact");
		model.addAttribute("contact", new Contact());
		return "views/add_contact_form";
	}
	
	@PostMapping("/process-contact")
	public String AddContactForm(@ModelAttribute Contact contact,Principal principal) {
		User user = this.userrepo.getUserByUserName(principal.getName());
		contact.setUser(user);
		user.getContact().add(contact);
		this.userrepo.save(user);
		System.out.println(contact);
		return "views/add_contact_form";
	}

		
	

}
