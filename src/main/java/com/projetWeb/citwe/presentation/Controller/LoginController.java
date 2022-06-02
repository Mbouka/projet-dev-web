package com.projetWeb.citwe.presentation.controller;


import com.projetWeb.citwe.model.entities.User;
import com.projetWeb.citwe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RolesAllowed("USER")
	@RequestMapping("/*")
	public String getUser(){


		return "UserAcceuil";
	}

	@RolesAllowed("ADMIN")
	@RequestMapping("/admin")
	public String getAdmin()
	{


		return "indexadmin";
	}
	@GetMapping(value={"/login"})
	public String login(HttpSession session){

		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		final User user = userService.findUserByEmail(auth.getName());
		if(user!= null )
			session.setAttribute("userName", user.getUsername());
		else
			session.setAttribute("userName","");

		return "login";
	}


	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		final ModelAndView modelAndView = new ModelAndView();
		final User user = new User();
		modelAndView.addObject("user", user);

		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser( User user, BindingResult bindingResult) {

		final ModelAndView modelAndView = new ModelAndView();

		final User userExists = userService.findUserByEmail(user.getEmail());

		if (userExists != null) {
			bindingResult
			.rejectValue("email", "error.user",
					"There is already a user registered with the email provided");
		}

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {

			userService.saveUser(user);

			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");

		}
		return modelAndView;
	}


	@RequestMapping(value="/admin/home", method = RequestMethod.GET)
	public ModelAndView home(){
		final ModelAndView modelAndView = new ModelAndView();
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		final User user = userService.findUserByEmail(auth.getName());

		modelAndView.addObject("userName", "Welcome " + user.getUsername() + " " + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}


}
