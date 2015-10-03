<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Page</title>
</head>
<body>
	<p>This is a employee page.</p>
	<p>
		Admin Email:
		<%=config.getInitParameter("admin-email")%>

		<!-- member methods and variables of servlet class -->
		<%!public static int a = 0;%>
		<%
		    Date currDate = new Date();
		    System.out.println("Current Date: " + currDate);
		%>
	</p>
</body>
</html>