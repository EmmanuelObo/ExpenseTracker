package com.emmaobo.expensetracker.command;

import java.math.BigDecimal;

import javax.persistence.EntityManagerFactory;

import com.emmaobo.expensetracker.interfaces.CentralCommand;
import com.emmaobo.expensetracker.model.ExpenseList;
import com.emmaobo.expensetracker.model.User;
import com.emmaobo.expensetracker.service.UserService;

public class CreateListCommand implements CentralCommand<ExpenseList>{

	private UserService myService;
	private ExpenseList newList;
	private User sessionUser;
	
	public CreateListCommand(EntityManagerFactory emf, ExpenseList newList, User currentUser) 
	{
		myService = new UserService(emf);
		this.newList = newList;
		this.sessionUser = currentUser;
		this.newList.setOwner(sessionUser);
		this.newList.setTotal(new BigDecimal("0"));
	}


	@Override
	public ExpenseList execute() 
	{
		sessionUser.addList(newList);
		myService.addNewList(sessionUser, sessionUser.getId(), newList);
		return newList;
	}
}
