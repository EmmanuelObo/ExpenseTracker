package com.emmaobo.expensetracker.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.emmaobo.expensetracker.model.ExpenseList;
import com.emmaobo.expensetracker.model.User;

public class UserServiceTest {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("expense_tracker");
	private User testUser;
	private String testUsername;
	private String testPassword;
	private UserService testDAO;
	
	
	@Before
	public void setup()
	{
		testUsername = "MannyO";
		testPassword = "password";
		testUser = new User();
		
		testUser.setUsername(testUsername);
		testUser.setPassword(testPassword);
		
		testDAO = new UserService(emf);
		
	}
	
	@Test
	public void testRead() 
	{
		User resultUser = testDAO.read(testUser);
		assertNotNull(resultUser);
		assertTrue(resultUser instanceof User);
		
		assertTrue(2L == resultUser.getId());
		
		assertEquals("emmaobo@yahoo.com", resultUser.getEmail());
		
		assertEquals(testPassword, resultUser.getPassword());
	}

	
	@Test
	public void testViewUsersLists()
	{
		List<ExpenseList> usersList = testDAO.viewUsersLists(2L);
		
		for(ExpenseList list : usersList)
		{
			System.out.println(list.getTitle());
		}
	}
	
	@Test
	public void testRemoveUsersList()
	{
		System.out.println(testDAO.removeUsersList(2L, 74L));
	}
}
