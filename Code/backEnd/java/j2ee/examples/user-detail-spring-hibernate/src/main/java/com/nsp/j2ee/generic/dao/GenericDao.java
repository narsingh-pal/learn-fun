package com.nsp.j2ee.generic.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T extends Serializable> {
	T findOne(long id);
	List<T> findAll();
	void create(T entity);
	void update(T entity);
	void delete(T entity);
	void deleteById(long entityId);
	List<T> findAllByExample(T entity);
	void clear();
	void flush();
	Serializable save(T entity);
	void saveOrUpdate(T entity);
	void deleteAll();
	List<T> findAllUsingCriteria();
	T findOneByColumnName(String fieldName, String fieldValue);
	List<T> findAllByColumnName(String fieldName, String fieldValue);
	T findByExample(T entity);
}