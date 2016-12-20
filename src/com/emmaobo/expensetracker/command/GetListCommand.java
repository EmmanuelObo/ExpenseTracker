package com.emmaobo.expensetracker.command;

import javax.persistence.EntityManagerFactory;

import com.emmaobo.expensetracker.interfaces.CentralCommand;
import com.emmaobo.expensetracker.model.ExpenseList;
import com.emmaobo.expensetracker.model.User;
import com.emmaobo.expensetracker.service.UserService;

public class GetListCommand implements CentralCommand<ExpenseList>
{	
	private UserService myService;
	private User sessionUser;
	private Long listID;
	
	public GetListCommand(EntityManagerFactory emf, User sessionUser, Long listID)
	{
		this.myService = new UserService(emf);
		this.listID = listID;
		this.sessionUser = sessionUser;
	}

	@Override
	public ExpenseList execute() {
		return myService.retrieveList(sessionUser.getId(), listID);
	}
	
	
}
