package com.emmaobo.expensetracker.command;

import javax.persistence.EntityManagerFactory;

import com.emmaobo.expensetracker.interfaces.CentralCommand;
import com.emmaobo.expensetracker.model.User;
import com.emmaobo.expensetracker.service.UserService;

public class RemoveListCommand implements CentralCommand<Boolean>
{
	private UserService myService;
	private User sessionUser;
	private Long listID;
	
	public RemoveListCommand(EntityManagerFactory emf, User sessionUser, Long listID)
	{
		myService = new UserService(emf);
		this.sessionUser = sessionUser;
		this.listID = listID;
	}

	@Override
	public Boolean execute() 
	{
		return myService.removeUsersList(sessionUser.getId(), listID);
	}

}
