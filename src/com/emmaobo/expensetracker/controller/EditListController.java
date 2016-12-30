package com.emmaobo.expensetracker.controller;

import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.emmaobo.expensetracker.command.AddItemCommand;
import com.emmaobo.expensetracker.command.GetListCommand;
import com.emmaobo.expensetracker.model.ExpenseList;
import com.emmaobo.expensetracker.model.Item;
import com.emmaobo.expensetracker.model.User;

@Controller
public class EditListController {

	
	@RequestMapping(value="/edit-list", method=RequestMethod.POST)
	public String gotoEditListView(HttpServletRequest request, @RequestParam(name="listID") Long listID, Model model)
	{
		 ApplicationContext context = (ApplicationContext)request.getServletContext().getAttribute("context");
		 User sessionUser = (User)request.getServletContext().getAttribute("user");
		GetListCommand cmd = new GetListCommand((EntityManagerFactory)context.getBean("emf"),
				sessionUser, listID);
		
		request.getServletContext().setAttribute("list", cmd.execute());
		model.addAttribute("item", new Item());
		return "edit-list";
	}
	
	@RequestMapping(value="/add-item", method=RequestMethod.POST)
	public String gotoAddedItemListView(Item item, HttpServletRequest request, Model model)
	{
		//TODO Add functionality to save changes to list 
		//TODO JavaScript to make editing list dynamic
		ExpenseList list = (ExpenseList)request.getServletContext().getAttribute("list");
		 ApplicationContext context = (ApplicationContext)request.getServletContext().getAttribute("context");
		AddItemCommand addItemCmd = new AddItemCommand((EntityManagerFactory)context.getBean("emf"), item, list);
		
		addItemCmd.execute();
		return "edit-list";
	}
}
