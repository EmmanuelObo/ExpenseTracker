package com.emmaobo.expensetracker.command;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import com.emmaobo.expensetracker.interfaces.CentralCommand;
import com.emmaobo.expensetracker.model.ExpenseList;
import com.emmaobo.expensetracker.model.User;
import com.emmaobo.expensetracker.service.UserService;

public class ViewListsCommand implements CentralCommand<List<ExpenseList>>
{

	private User sessionUser;
	private UserService myService;

	public ViewListsCommand(User sessionUser, EntityManagerFactory emf) 
	{
		this.myService = new UserService(emf);
		this.sessionUser = sessionUser;
	}
	

	@Override
	public List<ExpenseList> execute() 
	{
		return myService.viewUsersLists(sessionUser.getId());
	}

}
