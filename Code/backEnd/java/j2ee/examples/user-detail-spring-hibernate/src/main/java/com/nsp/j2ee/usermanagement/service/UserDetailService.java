package com.nsp.j2ee.usermanagement.service;

import java.util.List;

import com.nsp.j2ee.usermanagement.models.UserDetail;

public interface UserDetailService {

	void addNewUserDetail(UserDetail userDetail);

	List<UserDetail> getAllUserDetails();

	UserDetail getUserDetailById(Long id);

	List<UserDetail> getMatchingUserDetail(UserDetail u);

	UserDetail getUserDetailByObject(UserDetail user);

	void removeUserDetail(UserDetail user);

	List<UserDetail> getAllUsers();

	boolean isUserDetailExist(UserDetail user);

	UserDetail updateUserDetail(UserDetail user);
}
