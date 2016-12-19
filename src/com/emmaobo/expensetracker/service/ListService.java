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
	public ExpenseList read(ExpenseList list)
	{	
		return null;
	}

	@Override
	public List<ExpenseList> readAll() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ExpenseList updatedEntity, Long id) {
		// TODO Auto-generated method stub
		return false;
	}
}
