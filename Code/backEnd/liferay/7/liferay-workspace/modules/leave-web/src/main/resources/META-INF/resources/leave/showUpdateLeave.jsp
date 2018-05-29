<%@page import="com.liferay.portal.util.PortalImpl"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.nsp.j2ee.liferay.leave.model.Leave"%>
<%@page import="com.nsp.j2ee.liferay.leave.service.LeaveLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="../init.jsp" %>
Update Leave
<liferay-portlet:actionURL name="leave_updateLeave" var="updateLeave">
    <portlet:param name="mvcActionCommand" value="leave_updateLeave" />
</liferay-portlet:actionURL>
<%@ include file="../user-display.jspf" %>

<%
    String redirect = ParamUtil.getString(request, "backURL");
    int leaveId = ParamUtil.getInteger(request, "leaveId");
    Leave leave = LeaveLocalServiceUtil.getLeave(leaveId);
    request.setAttribute("leave", leave);
%>
<h2>userId : <%= themeDisplay.getRealUserId() %></h2>
<h3>userName=<%= themeDisplay.getRealUser().getFullName() %></h3>
<aui:form action="<%= updateLeave %>" cssClass="container-fluid-1280" method="post" name="fm">
    <aui:fieldset markupView="lexicon">
        <aui:input name="name"></aui:input>
        <liferay-ui:input-date name="startDate" monthValue="02" yearValue="2017"></liferay-ui:input-date>
        <liferay-ui:input-date name="endDate" monthValue="02" yearValue="2017"></liferay-ui:input-date>
        <aui:button type="submit"></aui:button>
    </aui:fieldset>
</aui:form>

<a href="<%= redirect %>">Back to All</a>