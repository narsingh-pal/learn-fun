package com.nsp.j2ee.usermanagement.application;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nsp.j2ee.usermanagement.models.UserDetail;
import com.nsp.j2ee.usermanagement.service.UserDetailService;



@Component
public class UserDetailApplication {

	final static Logger logger = Logger.getLogger(UserDetailApplication.class);

	@Autowired
	private UserDetailService userDetailService;
	public void performDbTasks()
	{
		// Get all userDetails
		List<UserDetail> userDetail = userDetailService.getAllUserDetails();
		logger.info(userDetail.size());
		printUserDetails(userDetail);
		UserDetail userDetailNew = new UserDetail((long) 1, "1444445","user1","user1@test.com","user1","ln");
		
		// Save new userDetail
		userDetailService.addNewUserDetail(userDetailNew);

		// Get all userDetails - to check added userDetail
		userDetail = userDetailService.getAllUserDetails();
		printUserDetails(userDetail);

		
	}

	private void printUserDetails(List<UserDetail> userDetailList) {
		if (userDetailList != null) {
			logger.debug("Found total " + userDetailList.size() + " records.");
			for (UserDetail userDetail : userDetailList) {
				logger.debug(userDetail.toString());
			}
		}
	}

}
