/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.nsp.j2ee.liferay.leave.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.nsp.j2ee.liferay.leave.exception.NoSuchLeaveException;
import com.nsp.j2ee.liferay.leave.model.Leave;
import com.nsp.j2ee.liferay.leave.service.base.LeaveLocalServiceBaseImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the leave local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.nsp.j2ee.liferay.leave.service.LeaveLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LeaveLocalServiceBaseImpl
 * @see com.nsp.j2ee.liferay.leave.service.LeaveLocalServiceUtil
 */
public class LeaveLocalServiceImpl extends LeaveLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.nsp.j2ee.liferay.leave.service.LeaveLocalServiceUtil} to access the leave local service.
	 */
	static final private Logger logger = LoggerFactory.getLogger(LeaveLocalServiceImpl.class);

	public int getLeaveCount(long userId){
		return leavePersistence.countByuserId(userId);
	}

	public Leave addLeave(String leaveName, long userId, long groupid, long companyId, Date startDate, Date endDate){
		long leaveId = counterLocalService.increment(Leave.class.getName());
		Leave leave = null;

		try{
			User user = userLocalService.getUser(userId);
			leave = leaveLocalService.createLeave(leaveId);
			leave.setUserId(userId);
			leave.setCreateDate(new Date());
			leave.setLeaveName(leaveName);
			leave.setStartDate(startDate);
			leave.setEndDate(endDate);
			leave.setUserName(user.getFullName());
			leave.setCompanyId(companyId);
			leave.setGroupId(groupid);
			logger.info("Adding leave " + leave +" to the database");
			leave = leaveLocalService.addLeave(leave);
		}catch (PortalException e){
			e.printStackTrace();
		}

		return leave;
	}

	public List<Leave> getLeavesByUserId(long userId){
		return leavePersistence.findByuserId(userId);
	}

	public List<Leave> getLeavesByUserId(long userId, int start, int end){
		return leavePersistence.findByuserId(userId,start,end);
	}

	public Leave deleteLeave(long leaveId) throws NoSuchLeaveException {
		return leavePersistence.remove(leaveId);
	}

    public Leave updateLeave(Leave leave)  {
        return leavePersistence.update(leave);
    }

}