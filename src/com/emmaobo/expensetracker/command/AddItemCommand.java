package com.emmaobo.expensetracker.command;

import javax.persistence.EntityManagerFactory;

import com.emmaobo.expensetracker.interfaces.CentralCommand;
import com.emmaobo.expensetracker.model.ExpenseList;
import com.emmaobo.expensetracker.model.Item;
import com.emmaobo.expensetracker.service.ItemService;

public class AddItemCommand implements CentralCommand<Boolean>{
	
	private ItemService myService;
	private Item item;
	private ExpenseList currentList;
	
	public AddItemCommand(EntityManagerFactory emf, Item item, ExpenseList currentList)
	{
		this.myService = new ItemService(emf);
		this.item = item;
		this.currentList = currentList;
	}

	@Override
	public Boolean execute() 
	{
		item.setList(currentList);
		currentList.addItem(item);
		return myService.addItem(item);
	}

}
