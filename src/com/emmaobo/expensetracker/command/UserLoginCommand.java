package com.emmaobo.expensetracker.command;

import javax.persistence.EntityManagerFactory;

import com.emmaobo.expensetracker.interfaces.CentralCommand;
import com.emmaobo.expensetracker.model.User;
import com.emmaobo.expensetracker.service.UserService;

public class UserLoginCommand implements CentralCommand<User> 
{
	private UserService myService;
	private User user;
	
	public UserLoginCommand(EntityManagerFactory emf, User user)
	{
		this.myService = new UserService(emf);
		this.user = user;
	}
	
	@Override
	public User execute()
	{
		User verifiedUser = myService.read(user);
		return verifiedUser;
	}
	
}
