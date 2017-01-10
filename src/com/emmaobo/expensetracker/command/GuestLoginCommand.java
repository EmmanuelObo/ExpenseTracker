package com.emmaobo.expensetracker.command;

import javax.persistence.EntityManagerFactory;

import com.emmaobo.expensetracker.enumeration.AccountType;
import com.emmaobo.expensetracker.interfaces.CentralCommand;
import com.emmaobo.expensetracker.model.User;
import com.emmaobo.expensetracker.service.UserService;

public class GuestLoginCommand implements CentralCommand<User>{

	private UserService myService;
	private User guest;
	
	public GuestLoginCommand(EntityManagerFactory emf)
	{
		this.myService = new UserService(emf);
		guest = new User();
		guest.setAccount(AccountType.GUEST);
	}
	
	
	@Override
	public User execute() 
	{
		User verifiedGuestUser = myService.retrieveUser(guest);
		return verifiedGuestUser;
	}

}
