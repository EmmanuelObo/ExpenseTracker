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
import com.emmaobo.expensetracker.command.RemoveItemCommand;
import com.emmaobo.expensetracker.model.ExpenseList;
import com.emmaobo.expensetracker.model.Item;
import com.emmaobo.expensetracker.model.User;

@Controller
public class EditListController {

	@RequestMapping("/edit-list")
	public String loadEditListView()
	{
		return "edit-list";
	}
	
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
	
//	@RequestMapping(value="/add-item", method=RequestMethod.POST)
//	public String gotoAddedItemListView(Item item, HttpServletRequest request, Model model)
//	{
//		ExpenseList list = (ExpenseList)request.getServletContext().getAttribute("list");
//		 ApplicationContext context = (ApplicationContext)request.getServletContext().getAttribute("context");
//		AddItemCommand addItemCmd = new AddItemCommand((EntityManagerFactory)context.getBean("emf"), item, list);
//		model.addAttribute("item", new Item());
//		
//		addItemCmd.execute();
//		return "edit-list";
//	}
	
	@RequestMapping(value="/remove-item", method=RequestMethod.POST)
	public String gotoRemoveItemListView(@RequestParam(name="itemId") Long itemID, 
			@RequestParam(name="currentListID") Long listID,
			HttpServletRequest request,
			Model model)
	{
		ApplicationContext context = (ApplicationContext)request.getServletContext().getAttribute("context");
		
		 User sessionUser = (User)request.getServletContext().getAttribute("user");
		GetListCommand cmd = new GetListCommand((EntityManagerFactory)context.getBean("emf"),
				sessionUser, listID);
		
		
		RemoveItemCommand removeItemCmd = new RemoveItemCommand((EntityManagerFactory)context.getBean("emf"),
				itemID, cmd.execute());
		
		model.addAttribute("item", new Item());
		
		removeItemCmd.execute();
		
		return "edit-list";
	}
}
