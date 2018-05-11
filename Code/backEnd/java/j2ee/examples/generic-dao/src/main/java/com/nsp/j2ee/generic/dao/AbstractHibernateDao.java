package com.nsp.j2ee.generic.dao;

import java.io.Serializable;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;


import java.lang.reflect.ParameterizedType;
@SuppressWarnings("unchecked")
public abstract class AbstractHibernateDao<T extends Serializable> implements GenericDao<T> {

	@Autowired
	SessionFactory sessionFactory;
	
	private Class<T> entityClass;

	public AbstractHibernateDao() {
		this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	

	public final void setEntityClass(Class<T> entityClassToSet) {
		this.entityClass = entityClassToSet;
	}

	public T findOne(long id) {
		return (T) getCurrentSession().get(entityClass, id);
	}

	public List<T> findAll() {
		return getCurrentSession().createQuery("from " + entityClass.getName()).list();

	}
	
	public T findOneByColumnName(String fieldName, String fieldValue) {
		return (T)getCurrentSession().createCriteria(this.entityClass).add(Restrictions.eq(fieldName, fieldValue)).uniqueResult();
	}
	
	public List<T> findAllByColumnName(String fieldName, String fieldValue) {
		return getCurrentSession().createCriteria(this.entityClass).add(Restrictions.eq(fieldName, fieldValue)).list();
	}
	
	public List<T> findAllByColumnName(String fieldName, T entity) {
		return getCurrentSession().createCriteria(this.entityClass).add(Restrictions.eq(fieldName, entity)).list();
	}

	public List<T> findAllUsingCriteria() {
		return getCurrentSession().createCriteria(this.entityClass).list();
	}
	
	public void create(T entity) {
		getCurrentSession().persist(entity);
	}
	
	public Long save(T entity) {
		return (Long) getCurrentSession().save(entity);
	}

	public void saveOrUpdate(T entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	public void update(T entity) {
		getCurrentSession().merge(entity);
	}

	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	public void deleteById(long entityId) {
		T entity = findOne(entityId);
		delete(entity);
	}

	public void deleteAll() {
		List<T> entities = findAll();
		for (T entity : entities) {
			getCurrentSession().delete(entity);
		}
	}
	
	public List<T> findAllByExample(T entity) {
		Example example = Example.create(entity).ignoreCase().enableLike().excludeZeroes();
		return getCurrentSession().createCriteria(this.entityClass).add(example).list();
	}
	
	public T findByExample(T entity) {
		Example example = Example.create(entity).ignoreCase().enableLike(MatchMode.ANYWHERE);
	    return (T)getCurrentSession().createCriteria(this.entityClass).add(example).uniqueResult();
	}
	
	public void clear() {
		getCurrentSession().clear();

	}

	public void flush() {
		getCurrentSession().flush();
	}
	
	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}