<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<%-- <p>Value from session is ${sessionScope.userName}   <%= session.getAttribute( "userName" ) %></p> --%>
	<p>Value from session is ${userName}</p>
</body>
</html>