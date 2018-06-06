<%@ include file="../init.jsp" %>
<portlet:actionURL name="actionMethod1" var="actionURLByPortletTagURL">
</portlet:actionURL>
<portlet:actionURL name="actionMethod2" var="actionURLByPortletTagURL2">
</portlet:actionURL>

<portlet:renderURL  var="nextPageRenderUrl" windowState="normal">
    <portlet:param name="jspPage" value="/jsp/navigationdemo/view2.jsp"/>
    <portlet:param name="nextPage" value="Page 2"/>
</portlet:renderURL>


<h1>Hello Generic portlet</h1>
<p class="caption">
    <liferay-ui:message key="demo-generic-portlet.caption"/>
</p>


<a href="${actionURLByPortletTagURL}">Action URL demo</a> <br/>
<a href="${actionURLByPortletTagURL2}">Action URL2 demo</a> <br/>

<a href="${nextPageRenderUrl}">Next Page</a> <br/>