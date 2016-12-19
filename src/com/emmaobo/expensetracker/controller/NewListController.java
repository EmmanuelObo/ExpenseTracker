package com.emmaobo.expensetracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emmaobo.expensetracker.model.ExpenseList;

@Controller
public class NewListController {

	@RequestMapping("/create-list")
	public String gotoCreateNewListView(Model model)
	{
		model.addAttribute("newList", new ExpenseList());
		return "create-list";
	}
}
