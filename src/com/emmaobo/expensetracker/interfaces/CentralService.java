package com.emmaobo.expensetracker.interfaces;

import java.util.List;

public interface CentralService<T> 
{
	public T read(Long id);
	public List<T> readAll();
	public T write(T entity);
	public boolean delete(Long id);
	public boolean update(T updatedEntity, Long id);
}
