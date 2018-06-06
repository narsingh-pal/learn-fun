<%@ include file="/WEB-INF/jsp/init.jsp" %>
<portlet:actionURL var="actionURLByPortletTagURL">
    <portlet:param name="action" value="actionMethod1"></portlet:param>
</portlet:actionURL>
<portlet:actionURL name="actionMethod2" var="actionURLByPortletTagURL2">
</portlet:actionURL>
<portlet:renderURL  var="nextPageRenderUrl" windowState="normal">
    <portlet:param name="jspPage" value="/jsp/navigationdemo/view2.jsp"/>
    <portlet:param name="nextPage" value="Page 2"/>
</portlet:renderURL>

<h1>Hello Spring portlet</h1>
<p>
	<b><liferay-ui:message key="spring-mvc-demo-portlet.caption"/></b>
</p>
<a href="${actionURLByPortletTagURL}">Action URL demo</a> <br/>
<a href="${actionURLByPortletTagURL2}">Action URL2 demo</a> <br/>
<a href="${nextPageRenderUrl}">Next Page</a> <br/>