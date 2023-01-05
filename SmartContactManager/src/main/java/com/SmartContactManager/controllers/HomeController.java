package com.SmartContactManager.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SmartContactManager.dao.UserRepository;
import com.SmartContactManager.entities.Contact;
import com.SmartContactManager.entities.User;
import com.SmartContactManager.helper.Message;

@Controller
public class HomeController {
	@Autowired
	private UserRepository userrepo;

	@RequestMapping("/")
	public String login() {
		return "login";
	}

	@RequestMapping("/home")
	public String test(Model model) {
		/*
		 * User user = new User(); user.setName("Salman"); Contact cont = new Contact();
		 * cont.setDescription("desc"); cont.setEmail("email@gmail.com");
		 * cont.setPhone("7006584939"); user.setEmail("email@gmail.com");
		 * cont.setUser(user); List<Contact> contt = List.of(cont);
		 * user.setContact(contt); userrepo.save(user); model.addAttribute("user",
		 * user);
		 */

		return "views/home";
	}

	@RequestMapping("/register")
	public String Signup(Model model) {
		model.addAttribute("title", "About-Smart Contact Manager");
		model.addAttribute("user", new User());

		return "views/signup";
	}

	@PostMapping("/do_register")
	public String RegisterUser(@Valid @ModelAttribute("user") User user,BindingResult result,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model,HttpSession session) {
		try {
			if (!agreement) {
				System.out.println("you have not agreed to terms and conditions");
				throw new Exception("you have not agreed to terms and conditions");
			}
			if(result.hasErrors()) {
				System.out.println("ERROR"+result.toString());
				model.addAttribute("user",user);
				return "views/signup";
			}
			user.setRole("ROLE_USER");
			user.setEnabled(true);
			user.setImageUrl("default.png");
			model.addAttribute("user", user);

			System.err.println(agreement);
			User res = userrepo.save(user);
			System.out.println(res);
			model.addAttribute("user",new User());
			session.setAttribute("message", new Message("Successfully Registered!!","alert-success"));
			return "views/signup";

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message", new Message("Something Went Wrong!!"+e.getMessage(),"alert-danger"));
			return "views/signup";
		}

		
	}

}
