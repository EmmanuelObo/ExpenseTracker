package com.emmaobo.expensetracker.controller;

import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.emmaobo.expensetracker.command.RemoveListCommand;
import com.emmaobo.expensetracker.command.ViewListsCommand;
import com.emmaobo.expensetracker.model.User;

@Controller
public class ManageListsController {

	@RequestMapping("/view-lists")
	public String gotoManageListsView(HttpServletRequest request, Model model)
	{
		User sessionUser = (User)request.getServletContext().getAttribute("user");
		ApplicationContext context = (ApplicationContext)request.getServletContext().getAttribute("context");
		ViewListsCommand cmd = new ViewListsCommand(sessionUser, (EntityManagerFactory)context.getBean("emf"));
		
		sessionUser.setList(cmd.execute());
		
		model.addAttribute("usersLists", sessionUser.getList());
		return "view-lists";
	}
	
	@RequestMapping(value="/view-lists", method=RequestMethod.POST)
	public String removeSelectedList(Model model, @RequestParam(name="listID")Long listID, 
			HttpServletRequest request)
	{
		ApplicationContext context = (ApplicationContext)request.getServletContext().getAttribute("context");
		User sessionUser = (User)request.getServletContext().getAttribute("user");
		
		RemoveListCommand removeListCmd = new RemoveListCommand((EntityManagerFactory)context.getBean("emf"),
				sessionUser, listID);
		
		ViewListsCommand viewListCmd = new ViewListsCommand(sessionUser, (EntityManagerFactory)context.getBean("emf"));
		
		removeListCmd.execute();
		
		sessionUser.setList(viewListCmd.execute());
		
		model.addAttribute("usersLists", sessionUser.getList());
		
		return "view-lists";
	}
}
