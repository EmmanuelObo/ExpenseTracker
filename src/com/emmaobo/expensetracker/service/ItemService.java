package com.emmaobo.expensetracker.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.emmaobo.expensetracker.interfaces.CentralService;
import com.emmaobo.expensetracker.model.Item;

public class ItemService implements CentralService<Item> {

	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction et;
	
	public ItemService(EntityManagerFactory emf)
	{
		this.emf = emf;
	}
	
	@Override
	public Item read(Long id) 
	{
		em = emf.createEntityManager();
		et = em.getTransaction();
		
		return em.find(Item.class, id);
	}

	@Override
	public List<Item> readAll() 
	{
		em = emf.createEntityManager();
		et = em.getTransaction();
		TypedQuery<Item> query = em.createQuery("SELECT i FROM Item i", Item.class);
		List<Item> dbItems = query.getResultList();
		return dbItems;
	}

	@Override
	public Item write(Item item) 
	{
		em = emf.createEntityManager();
		et = em.getTransaction();
		
		et.begin();
		em.persist(item);
		et.commit();
		em.close();
		
		return null;
	}

	@Override
	public boolean delete(Long id) 
	{
		em = emf.createEntityManager();
		et = em.getTransaction();
		Item dbItem = em.find(Item.class, id);
		if(dbItem != null)
		{
			et.begin();
			em.detach(dbItem);
			et.commit();
			em.close();
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Item updatedItem, Long id) 
	{
		em = emf.createEntityManager();
		et = em.getTransaction();
		Item dbItem = em.find(Item.class, id);
		if(dbItem != null)
		{
			dbItem = updatedItem;
			et.begin();
			em.merge(updatedItem);
			et.commit();
			em.close();
			return true;
		}
		return false;
	}
	
	public boolean removeItem(Long itemID)
	{
		em = emf.createEntityManager();
		et = em.getTransaction();
		
		Item dbItem = em.find(Item.class, itemID);
		
		if(dbItem != null)
		{
			et.begin();
			em.remove(dbItem);
			et.commit();
			em.close();
			return true;
		}
		return false;
	}
	
	public boolean addItem(Item item)
	{
		return write(item) == null ? true : false;
	}
}
