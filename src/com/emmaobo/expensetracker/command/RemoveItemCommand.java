package com.emmaobo.expensetracker.command;

import javax.persistence.EntityManagerFactory;

import com.emmaobo.expensetracker.interfaces.CentralCommand;
import com.emmaobo.expensetracker.model.ExpenseList;
import com.emmaobo.expensetracker.service.ItemService;

public class RemoveItemCommand implements CentralCommand<Boolean>{
	
	private ItemService myService;
	private Long itemID;
	private ExpenseList currentList;
	private SaveListCommand cmd;
	
	public RemoveItemCommand(EntityManagerFactory emf, Long itemID, ExpenseList currentList)
	{
		myService = new ItemService(emf);
		this.itemID = itemID;
		this.currentList = currentList;
		cmd = new SaveListCommand(emf, currentList);
	}

	@Override
	public Boolean execute() 
	{
		currentList.removeItem(myService.read(itemID));
		cmd.execute();
		return myService.removeItem(itemID);
	}

}
