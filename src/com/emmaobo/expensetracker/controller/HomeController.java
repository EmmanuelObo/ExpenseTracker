package com.emmaobo.expensetracker.controller;

import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emmaobo.expensetracker.command.CreateListCommand;
import com.emmaobo.expensetracker.model.ExpenseList;
import com.emmaobo.expensetracker.model.User;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String gotoHomeView(HttpServletRequest request, Model model)
	{
		User sessionUser = (User)request.getServletContext().getAttribute("user");
		if(sessionUser == null)
		{
			return "redirect:/login";
		}
		return "home";
	}

	@RequestMapping(value = "/home", method=RequestMethod.POST)
	public String gotoNewlyCreatedListView(ExpenseList newList, HttpServletRequest request, Model model)
	{
		String feedback;
		User sessionUser = (User)request.getServletContext().getAttribute("user");
		ApplicationContext context = (ApplicationContext)request.getServletContext().getAttribute("context");
		CreateListCommand cmd = new CreateListCommand((EntityManagerFactory)context.getBean("emf"), newList, sessionUser);
		
		if(cmd.execute() != null)
			feedback = newList.getTitle() + " successfully created";
		
		else
			feedback = "Error creating list";

		model.addAttribute("feedback", feedback);
		return "home";
	}
	
	@RequestMapping("/logout")
	public String gotoLogOutView(HttpServletRequest request, Model model)
	{
		request.getServletContext().removeAttribute("user");
		return "welcome";
	}
}
