package com.emmaobo.expensetracker.daos;

import java.math.BigDecimal;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.emmaobo.expensetracker.enumeration.Priority;
import com.emmaobo.expensetracker.model.Item;
import com.emmaobo.expensetracker.service.ItemService;

public class ItemDAOTest {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("expense_tracker");
	private ItemService testDAO;
	private Item testItem1;
	private Item testItem2;
	
	@Before
	public void setup()
	{
			testItem1 = new Item("First Test Item", new BigDecimal("10.99"));
			
			testItem2 = new Item("Second Test Item", new BigDecimal("1.99"), Priority.HIGH);
			
			testDAO = new ItemService(emf);
	}

	@Test
	public void testWrite() {
		testDAO.write(testItem1);
		testDAO.write(testItem2);
	}

}
