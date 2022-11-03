package com.gcu.data;

import java.util.List;

/**
 * Define the following public CRUD methods to
support data persistence.

 * @author jjk14
 *
 * @param <T>
 */
public interface DataAccessInterface <T>{
	public List<T> findAll();
	public T findById(int id);
	public boolean create(T t);
	public boolean update(T t);
	public boolean delete(T t);
}
