package com.SmartContactManager.controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.SmartContactManager.dao.UserRepository;
import com.SmartContactManager.entities.Contact;
import com.SmartContactManager.entities.User;
import com.SmartContactManager.helper.Message;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserRepository userrepo;

	@ModelAttribute
	public void addCommonData(Model m, Principal principal) {
		String UserName = principal.getName();
		System.err.println(UserName);
		User usr = userrepo.getUserByUserName(UserName);
		System.err.println(usr);
		m.addAttribute("user", usr);
	}

	@RequestMapping("/index")
	public String dashboard(Model model, Principal principal) {

		return "views/user_dashboard";
	}

	// add form Controller
	@GetMapping("/add-contact")
	public String openAddContactForm(Model model) {
		model.addAttribute("title", "Add Contact");
		model.addAttribute("contact", new Contact());
		return "views/add_contact_form";
	}

	@PostMapping("/process-contact")
	public String AddContactForm(@ModelAttribute Contact contact, @RequestParam("profileImage") MultipartFile file,
			Principal principal,HttpSession session) {
		try {
			User user = this.userrepo.getUserByUserName(principal.getName());

			if (file.isEmpty()) {
				System.out.println("File Empty!!");
			} else {
				contact.setImage(file.getOriginalFilename());

				File saveFile = new ClassPathResource("static/images").getFile();
				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			}
			contact.setUser(user);
			user.getContact().add(contact);
			this.userrepo.save(user);
			System.out.println(contact);
			session.setAttribute("message", new Message("Your Contact is Added !!","success"));
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", new Message("Something went wrong !!","danger"));

		}
		return "views/add_contact_form";
	}

}
