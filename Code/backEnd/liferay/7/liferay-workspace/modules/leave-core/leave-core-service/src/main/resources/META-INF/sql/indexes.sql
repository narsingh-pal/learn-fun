create index IX_C38F8EE3 on nsp_Leave (userId);
create index IX_847B395D on nsp_Leave (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_5F4C731F on nsp_Leave (uuid_[$COLUMN_LENGTH:75$], groupId);