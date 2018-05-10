package com.nsp.j2ee.usermanagement.dao;

import java.util.List;

import com.nsp.j2ee.generic.dao.GenericDao;
import com.nsp.j2ee.usermanagement.models.UserDetail;



public interface UserDetailDAO extends GenericDao<UserDetail>{
	public void create(UserDetail p);
	public List<UserDetail> list();
	UserDetail findById(long id);
	UserDetail findByObj(UserDetail user);
}
