package com.emmaobo.expensetracker.controller;

import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emmaobo.expensetracker.command.GuestLoginCommand;
import com.emmaobo.expensetracker.command.UserLoginCommand;
import com.emmaobo.expensetracker.model.User;
import com.emmaobo.expensetracker.verification.LoginVerification;

@Controller
public class LoginController {
	
	
	@RequestMapping("/login")
	public String gotoLoginView(Model model, HttpServletRequest request)
	{
		if(LoginVerification.verifyLoggedInUser(request))
			return "home";
		
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String gotoWelcomeView(Model model, User user, HttpServletRequest request)
	{
		ApplicationContext context = (ApplicationContext)request.getServletContext().getAttribute("context");
		UserLoginCommand cmd = new UserLoginCommand((EntityManagerFactory)context.getBean("emf"), user);
		User loggedInUser = cmd.execute();
		
		if(loggedInUser != null)
		{
			request.getServletContext().setAttribute("user", loggedInUser);
			return "home";
		}
		else
		{
			model.addAttribute("errorMsg", "Invalid credentials, please try again");
			return "login";
		}
	}
	
	@RequestMapping(value="/login-guest")
	public String gotoGuestWelcomeView(Model model, HttpServletRequest request) 
	{
		ApplicationContext context = (ApplicationContext)request.getServletContext().getAttribute("context");
		GuestLoginCommand cmd = new GuestLoginCommand((EntityManagerFactory)context.getBean("emf"));
		
		User guestUser = cmd.execute();
		
		request.getServletContext().setAttribute("user", guestUser);
		return "home";
	}
}
