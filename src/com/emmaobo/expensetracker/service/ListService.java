package com.emmaobo.expensetracker.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.emmaobo.expensetracker.interfaces.CentralService;
import com.emmaobo.expensetracker.model.ExpenseList;

public class ListService implements CentralService<ExpenseList> {

	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction et;
	
	public ListService(EntityManagerFactory emf)
	{
		this.emf = emf;
	}
	
	@Override
	public ExpenseList read(Long id)
	{	
		return null;
	}

	@Override
	public List<ExpenseList> readAll() {
		em = emf.createEntityManager();
		et = em.getTransaction();
		
		et.begin();
		
		List<ExpenseList> lists = em.createQuery("SELECT expli FROM ExpenseList expli", ExpenseList.class).getResultList();
		
		return lists;
	}

	@Override
	public ExpenseList write(ExpenseList entity) 
	{
		em = emf.createEntityManager();
		et = em.getTransaction();
		
		if(entity != null)
		{
		et.begin();
		em.persist(entity);
		et.commit();
		em.close();
		}
		return entity;
	}
	
	public boolean saveListChanges(Long listID, ExpenseList updatedList)
	{
		return update(updatedList, listID);
	}

	@Override
	public boolean delete(Long id) {
		return false;
	}

	@Override
	public boolean update(ExpenseList updatedList, Long id) {
		em = emf.createEntityManager();
		et = em.getTransaction();
		
		ExpenseList dbList = em.find(ExpenseList.class, id);
		
		if(dbList != null)
		{
			et.begin();
			em.merge(updatedList);
			et.commit();
			em.close();
			return true;
		}
		
		return false;
	}
}
