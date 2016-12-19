package com.emmaobo.expensetracker.daos;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import com.emmaobo.expensetracker.model.User;
import com.emmaobo.expensetracker.service.UserService;

public class UserDAOTest {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("expense_tracker");
	private UserService testDAO;
	private User testUser;
	
	@Before
	public void setup()
	{
		testUser = new User("username", "password", "some@email.com");
		
		testDAO = new UserService(emf);
	}
	
	@Test
	public void testDAOInitialized() {
		assertNotNull(testDAO);
	}
	
	@Test
	public void testWriteToDB()
	{
		testDAO.write(testUser);
	}

}
