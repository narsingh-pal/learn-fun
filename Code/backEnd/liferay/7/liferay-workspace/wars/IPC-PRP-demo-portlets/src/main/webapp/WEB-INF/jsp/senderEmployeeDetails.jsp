<%@ include file="/WEB-INF/jsp/init.jsp" %>
<portlet:actionURL var="submitFormURL" name="handleEmployee"/>
<p>
	<b><liferay-ui:message key="ipc.prp.sender.caption"/></b>
</p>
<h1>Employee Details</h1>
Employee Name : ${employee.name}<br/>
Employee email : ${employee.email}