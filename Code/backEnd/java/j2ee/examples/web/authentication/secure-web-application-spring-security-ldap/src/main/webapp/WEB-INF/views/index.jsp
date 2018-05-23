<%-- This is the administrator page which requires authentication and
authorization to access. We use JSTL expressions to display the title
and message in the model. If the user is logged in, display his username
along with a logout link.  --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Security LDAP authentication Demo </title>
</head>
<body>
	<div align="center">
		<h1>Spring Security LDAP authentication Demo </h1>
		<a href="${pageContext.request.contextPath}/admin">Go to Administrator Page</a>
	</div>
</body>
</html>