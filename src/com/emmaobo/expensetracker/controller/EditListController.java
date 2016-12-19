package com.emmaobo.expensetracker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emmaobo.expensetracker.model.ExpenseList;

@RestController
public class EditListController 
{

	@RequestMapping("/edit-list")
	public ExpenseList edittedList(@RequestParam(name="listTitle")String title)
	{
		return new ExpenseList(title);
	}
}

