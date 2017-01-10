package com.emmaobo.expensetracker.command;

import javax.persistence.EntityManagerFactory;

import com.emmaobo.expensetracker.interfaces.CentralCommand;
import com.emmaobo.expensetracker.model.ExpenseList;
import com.emmaobo.expensetracker.service.ListService;

public class SaveListCommand implements CentralCommand<Boolean>{

	private ListService myService;
	ExpenseList updatedList;
	
	public SaveListCommand(EntityManagerFactory emf, ExpenseList updatedList)
	{
		myService = new ListService(emf);
		this.updatedList = updatedList;
	}

	@Override
	public Boolean execute() 
	{
		return myService.saveListChanges(updatedList.getId(), updatedList);
	}
}
