<%@ include file="/init.jsp" %>
<portlet:actionURL var="savePreferencesActionURL" name="savePreferences">
</portlet:actionURL>


<%
	PortletPreferences preferences = renderRequest.getPreferences();
	String portletResource = ParamUtil.getString(request, "portletResource");
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	String  background = portletPreferences.getValue("background", "");
	request.setAttribute("background",background);
%>


<form action="${savePreferencesActionURL}" name="savePreferenses"  method="POST">
	Select the background color:
	<input type="color" name="bgColor">
	<input type="submit">
</form>
