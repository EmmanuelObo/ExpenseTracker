package com.emmaobo.expensetracker.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.emmaobo.expensetracker.enumeration.Priority;
import com.emmaobo.expensetracker.model.ExpenseList;
import com.emmaobo.expensetracker.model.Item;
import com.emmaobo.expensetracker.model.User;

public class UserTest {

	
	private User testUser;
	private String testUsername;
	private String testPassword;
	private String testEmail;
	private String testItemName;
	private BigDecimal testCost;
	private Priority testPriority;
	private Long testExListID;
	private Long testUserID;
	private Long testItemID;
	private Item mockItem;
	private ExpenseList mockList;
	private String testNote;
	
	@Before
	public void setup()
	{
		testExListID = (long) 23;
		testUserID = (long) 5;
		testUsername = "username";
		testPassword = "password";
		testEmail = "test@gmail.com";
		
		testItemID = (long) 22;
		testItemName = "Test Item";
		testCost = new BigDecimal("9.99");
		testPriority = Priority.HIGH;
		testNote = "Test Note";
		
		mockItem = mock(Item.class);
		
		when(mockItem.getId()).thenReturn(testItemID);
		when(mockItem.getCost()).thenReturn(testCost);
		when(mockItem.getItemName()).thenReturn(testItemName);
		when(mockItem.getPriority()).thenReturn(testPriority);
		when(mockItem.getNote()).thenReturn(testNote);
		
		mockList = mock(ExpenseList.class);
		
		when(mockList.getId()).thenReturn(testExListID);
		
		testUser = new User(testUsername, testPassword, testEmail);
		testUser.setId(testUserID);
	}
	
	@Test
	public void testUserNotNull() 
	{
		assertNotNull(testUser);
	}
	
	@Test
	public void testUsername()
	{
		String errorMsg = "Username not properly set";
		
		assertEquals(errorMsg, testUsername, testUser.getUsername());
	}
	
	@Test
	public void testUserList()
	{
	}

}
