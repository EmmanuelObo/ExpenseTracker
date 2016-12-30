package com.emmaobo.expensetracker.command;

import javax.persistence.EntityManagerFactory;

import com.emmaobo.expensetracker.interfaces.CentralCommand;
import com.emmaobo.expensetracker.model.ExpenseList;
import com.emmaobo.expensetracker.model.Item;
import com.emmaobo.expensetracker.service.ListService;

public class AddItemCommand implements CentralCommand<Boolean>{
	
	private ListService myService;
	private Item item;
	private ExpenseList currentList;
	
	public AddItemCommand(EntityManagerFactory emf, Item item, ExpenseList currentList)
	{
		this.myService = new ListService(emf);
		this.item = item;
		this.currentList = currentList;
	}

	@Override
	public Boolean execute() 
	{
		item.setList(currentList);
		currentList.addItem(item);
		return myService.addNewItem(currentList.getId(), currentList, item);
	}

}
