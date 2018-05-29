create table nsp_Leave (
	uuid_ VARCHAR(75) null,
	leaveId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	leaveName VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null
);