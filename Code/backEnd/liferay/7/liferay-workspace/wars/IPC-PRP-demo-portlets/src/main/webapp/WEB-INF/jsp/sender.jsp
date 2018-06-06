<%@ include file="/WEB-INF/jsp/init.jsp" %>
<portlet:actionURL var="submitFormURL" name="handleEmployee"/>
<p>
	<b><liferay-ui:message key="ipc.prp.sender.caption"/></b>
</p>
<form:form name="employee" method="post" modelAttribute="employee" action="${submitFormURL}">
    <br/>
    <table>
        <tbody>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="email">Email</form:label></td>
            <td><form:input path="email"></form:input></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Submit Form">
            </td>
        </tr>
        </tbody>
    </table>
</form:form>