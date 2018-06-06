<%@ include file="/init.jsp" %>

<%
	String  background = portletPreferences.getValue("background", "");
	request.setAttribute("background",background);
%>

<div style="background: ${background};">

		<liferay-ui:message key="liferay-mvc-demo-portlet.caption" />

</div>

