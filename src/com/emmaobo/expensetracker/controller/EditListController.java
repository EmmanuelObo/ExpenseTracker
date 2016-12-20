package com.emmaobo.expensetracker.controller;

import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.emmaobo.expensetracker.command.GetListCommand;
import com.emmaobo.expensetracker.model.ExpenseList;
import com.emmaobo.expensetracker.model.User;

@RestController
public class EditListController 
{

	@RequestMapping("/edit-list")
	public ExpenseList edittedList(@RequestParam(value="listTitle")String title)
	{
		return new ExpenseList(title);
	}
	
	@RequestMapping(value="/edit-list", method=RequestMethod.POST)
	public ExpenseList edittingList(ExpenseList newList, 
			@RequestParam(value="listID") Long id,
			HttpServletRequest request)
	{
		ApplicationContext context = (ApplicationContext) request.getServletContext().getAttribute("context");
		User sessionUser = (User) request.getServletContext().getAttribute("user");
		GetListCommand cmd = new GetListCommand((EntityManagerFactory)context.getBean("emf"), sessionUser, id);
		
		newList = cmd.execute();
		
		newList.setOwner(null);
		newList.setItems(null);
		
		return newList;
	}
}

