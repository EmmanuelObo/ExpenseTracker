package com.emmaobo.expensetracker.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.emmaobo.expensetracker.enumeration.Priority;
import com.emmaobo.expensetracker.model.ExpenseList;
import com.emmaobo.expensetracker.model.Item;

public class ListServiceTest {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("expense_tracker");
	private ListService testDAO;
	private ItemService itemDAO;
	private Item testItem1;
	private Item testItem2;
	private List<Item> items;
	private ExpenseList testList;

	@Before
	public void setup()
	{
		items = new ArrayList<Item>();
		testItem1 = new Item("First Test Item", new BigDecimal("10.99"));
		
		testItem2 = new Item("Guest Created Item", new BigDecimal("19.99"), Priority.LOW);

		items.add(testItem1);
		items.add(testItem2);
		
		testList = new ExpenseList("Daily Expenses");
		
		testList.setItems(items);
		
		testDAO = new ListService(emf);
		
		itemDAO = new ItemService(emf);
	}
	
	
	@Test
	public void testWrite() 
	{
		itemDAO.write(testItem1);
		itemDAO.write(testItem2);
		testDAO.write(testList);
	}
	
	@Test
	public void testRead()
	{
	}

}
