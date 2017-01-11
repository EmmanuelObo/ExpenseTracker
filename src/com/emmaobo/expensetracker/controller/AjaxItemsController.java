package com.emmaobo.expensetracker.controller;

import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emmaobo.expensetracker.command.AddItemCommand;
import com.emmaobo.expensetracker.model.ExpenseList;
import com.emmaobo.expensetracker.model.Item;
import com.emmaobo.expensetracker.service.ItemService;

@RestController
public class AjaxItemsController {

	
	@RequestMapping(value="/add-item", method=RequestMethod.POST)
	public Item addItemToList(@RequestBody Item item, HttpServletRequest request)
	{
		ApplicationContext context = (ApplicationContext)request.getServletContext().getAttribute("context");
		ExpenseList currentList = (ExpenseList)request.getServletContext().getAttribute("list");
//		AddItemCommand cmd = new AddItemCommand((EntityManagerFactory)context.getBean("emf"), item, currentList);
		
//		cmd.execute();
		
		ItemService service = new ItemService((EntityManagerFactory)context.getBean("emf"));
		item.setList(currentList);
		service.addItem(item);
		System.out.println(currentList.getTitle());
		return item;
	}
}
