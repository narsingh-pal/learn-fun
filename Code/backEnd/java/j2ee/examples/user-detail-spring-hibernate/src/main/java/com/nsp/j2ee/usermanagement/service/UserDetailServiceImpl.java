package com.nsp.j2ee.usermanagement.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nsp.j2ee.usermanagement.dao.UserDetailDAO;
import com.nsp.j2ee.usermanagement.models.UserDetail;

@Service
@Transactional(readOnly = true)
public class UserDetailServiceImpl implements UserDetailService {

	final static Logger logger = Logger.getLogger(UserDetailServiceImpl.class);

	@Autowired
	UserDetailDAO userDetailDao;

	public List<UserDetail> getAllUserDetails() {
		logger.debug("Getting all userDetails...");
		return userDetailDao.findAll();
	}

	public UserDetail getUserDetailById(Long id) {
		logger.debug("Getting userDetail by id...");
		return userDetailDao.findOne(id);
	}

	public UserDetail getUserDetailByObject(UserDetail user) {
		logger.debug("Getting userDetail by object...");
		return userDetailDao.findByObj(user);
	}

	@Transactional(readOnly = false)
	public void addNewUserDetail(UserDetail userDetail) {
		UserDetail userDetailPersist = new UserDetail();

		userDetailPersist.setUserDetailId(userDetail.getUserDetailId());
		userDetailPersist.setUserId(userDetail.getUserId());
		userDetailPersist.setScreenName(userDetail.getScreenName());
		userDetailPersist.setEmail(userDetail.getEmail());
		userDetailPersist.setFirstName(userDetail.getFirstName());
		userDetailPersist.setLastName(userDetail.getLastName());

		List<UserDetail> userDetailList = userDetailDao.findAllByExample(userDetailPersist);
		if (userDetailList == null || userDetailList.isEmpty()) {
			Long id = (Long) userDetailDao.save(userDetail);
			logger.debug("Id of new UserDetail " + id);
		} else {
			logger.debug("UserDetail " + userDetailPersist + " already exists");
		}
	}

	public List<UserDetail> getMatchingUserDetail(UserDetail u) {
		logger.debug("Getting MatchingUserDetail ...");
		return userDetailDao.findAllByExample(u);
	}
	
	@Transactional(readOnly = false)
	public void removeUserDetail(UserDetail user) {
		userDetailDao.delete(user);
	}

	public List<UserDetail> getAllUsers() {
		return userDetailDao.findAll();
	}

	public boolean isUserDetailExist(UserDetail user) {
		//List<UserDetail> userList = userDetailDao.findAllByExample(user);
		//return (userList == null || userList.isEmpty()) ? false : true;
		
		return (userDetailDao.findOne(user.getUserDetailId())==null) ? false : true;
	}

	// NOTE : Without this @Transactional annotation the update will not happen in the database
	@Transactional(readOnly = false)
	public UserDetail updateUserDetail(UserDetail user) {
		/*UserDetail dbUser = userDetailDao.findOne(user.getUserDetailId());

		if (dbUser == null)
			return null;*/

		userDetailDao.update(user);
		return user;
		
	}

}
