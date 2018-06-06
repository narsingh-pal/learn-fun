<%@ include file="../init.jsp" %>
<portlet:renderURL  var="backURL" windowState="normal">
    <portlet:param name="jspPage" value="/jsp/genericdemo/view.jsp"/>
</portlet:renderURL>


<h1>Hello Generic portlet navigation demo</h1>
Current Page is : <%=renderRequest.getParameter("nextPage")%>
<p class="caption">
    <liferay-ui:message key="demo-generic-portlet.caption"/>
</p>

<a href="${backURL}">GO BACK</a> <br/>