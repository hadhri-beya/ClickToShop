package com.isamm.clicktoshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.isamm.clicktoshop.entities.*;
public interface IDAO<T> {
	public abstract Long create(T obj);
	public abstract List<T> getAll();
	public abstract boolean delete(Long id);
	public abstract boolean update(T obj);
	public abstract T getById (Long id);
}
