package com.emmaobo.expensetracker.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.emmaobo.expensetracker.enumeration.AccountType;
import com.emmaobo.expensetracker.interfaces.CentralService;
import com.emmaobo.expensetracker.model.ExpenseList;
import com.emmaobo.expensetracker.model.User;

public class UserService implements CentralService<User>{
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction et;
	
	public UserService(EntityManagerFactory emf)
	{
		this.emf = emf;
	}

	@Override
	public User read(User user) {
		em = emf.createEntityManager();
		et = em.getTransaction();
		
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
		List<User> dbUsers = query.getResultList();
		
		for(User dbUser : dbUsers)
		{
			if(user.getAccount() == AccountType.GUEST && dbUser.getAccount() == AccountType.GUEST)
			{
				return dbUser;
			}
			if(dbUser.getUsername().equals(user.getUsername()) && dbUser.getPassword().equals(user.getPassword()))
			{
				return dbUser;
			}
			
		}
		return null;
	}

	@Override
	public User write(User user) {
		em = emf.createEntityManager();
		et = em.getTransaction();
		
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
		List<User> dbUsers = query.getResultList();
		
		for(User dbUser : dbUsers)
		{
			if(dbUser.getUsername().equalsIgnoreCase(user.getUsername()))
			{
				System.out.println("Username already taken, please try again");
				return null;
			}
		}
		
		et.begin();
		em.persist(user);
		et.commit();
		
		em.close();
		return null;
	}

	@Override
	public boolean delete(Long id) 
	{
		em = emf.createEntityManager();
		et = em.getTransaction();

		//TODO: Delete User with id from database
		return false;
	}

	@Override
	public boolean update(User updatedUser, Long id) 
	{
		em = emf.createEntityManager();
		et = em.getTransaction();
		
		User dbUser = em.find(User.class, id);
		if(dbUser != null)
		{
			et.begin();
			dbUser = updatedUser;
			em.merge(dbUser);
			et.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<User> readAll() 
	{
		em = emf.createEntityManager();
		et = em.getTransaction();
		
		List<User> dbUsers = (List<User>)em.createQuery("SELECT u FROM User u", User.class).getResultList();
		
		return dbUsers;
	}

	public boolean addNewList(User user, Long userID, ExpenseList list)
	{
		em = emf.createEntityManager();
		et = em.getTransaction();
		ListService listService = new ListService(emf);
		
		User dbUser = em.find(User.class, userID);
		if(dbUser != null)
		{
			try{
				listService.write(list);
				et.begin();
				dbUser = user;
				em.merge(dbUser);
				et.commit();
				return true;
			}catch(RollbackException e)
			{
				System.out.println("Rollback");
			}
		}
		return false;
	}
	
	public List<ExpenseList> viewUsersLists(Long id)
	{
		em = emf.createEntityManager();
		
		User user = em.find(User.class, id);
		
		return user.getList();
	}
	
	public boolean removeUsersList(Long userID, Long listID)
	{
		em = emf.createEntityManager();
		et = em.getTransaction();
		
		ExpenseList selectedList = em.find(ExpenseList.class, listID);
		
		if(selectedList == null)
			return false;
		
		if(selectedList.getOwner().getId() == userID)
		{
			et.begin();
			em.remove(selectedList);
			et.commit();
			em.close();
			return true;
		}
		return false;
	}
	
	public ExpenseList retrieveList(Long userID, Long listID)
	{
		em = emf.createEntityManager();
		et = em.getTransaction();
		
		ExpenseList selectedList = em.find(ExpenseList.class, listID);
		
		if(selectedList == null)
			return null;
		
		if(selectedList.getOwner().getId() == userID)
		{
			return selectedList;
		}
		
		return null;
	}
}