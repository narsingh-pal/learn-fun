package com.nsp.j2ee.usermanagement.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nsp.j2ee.generic.dao.AbstractHibernateDao;
import com.nsp.j2ee.usermanagement.dao.UserDetailDAO;
import com.nsp.j2ee.usermanagement.models.UserDetail;


@Repository
public class UserDetailDAOImpl  extends AbstractHibernateDao<UserDetail>  implements UserDetailDAO{
	public void create(UserDetail p) {
		create(p);
	}

	public UserDetail findById(long id) {
		return findOne(id);
	}
	
	public UserDetail findByObj(UserDetail user) {
		return findByExample(user);
	} 
	
	public List<UserDetail> list() {
		return findAll();
	}
}
