<%@page import="com.liferay.portal.util.PortalImpl"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.nsp.j2ee.liferay.leave.model.Leave"%>
<%@page import="com.nsp.j2ee.liferay.leave.service.LeaveLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="../init.jsp" %>

<%
    String redirect = ParamUtil.getString(request, "backURL");
    int leaveId = ParamUtil.getInteger(request, "leaveId");
    Leave leave = LeaveLocalServiceUtil.getLeave(leaveId);
    request.setAttribute("leave", leave);
%>
<%@ include file="../user-display.jspf" %>
<h1>Leave Information</h1>
<h2>userId : <%= themeDisplay.getRealUserId() %></h2>
<h3>userName=<%= themeDisplay.getRealUser().getFullName() %></h3>
<h3>Leave Type: ${leave.leaveName}  </h3>
<h3>Start Date :${leave.startDate}</h3>
<h3>End Date :${leave.endDate}</h3>
<%--<h3>Address :${leave.address}</h3>--%>
<br><br>
<a href="<%= redirect %>">Back to All</a>
