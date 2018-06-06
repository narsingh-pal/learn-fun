<%@ include file="/WEB-INF/jsp/init.jsp" %>

<portlet:renderURL  var="backURL" windowState="normal">
    <portlet:param name="jspPage" value="/WEB-INF/jsp/genericdemo/view.jsp"/>
</portlet:renderURL>
<h1>Hello Spring portlet navigation demo</h1>
Current Page is : <%=renderRequest.getParameter("nextPage")%>
<p class="caption">
    <b><liferay-ui:message key="spring-mvc-demo-portlet.caption"/></b>
</p>

<a href="${backURL}">GO BACK</a> <br/>