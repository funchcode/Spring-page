<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>In Login</title>
</head>
<body>
	<h2>In Login Page</h2>

	<c:if test="${param.error != null}">
		<h3>ID or Password is Failed</h3>
	</c:if>
	
	<form action="/login" method="post">
		<input type="text" name="username">
		<input type="password" name="password">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<button>LOGIN</button>
	</form>
	
	
	<ul>
	<%
		Enumeration<String> en = request.getAttributeNames();

		while(en.hasMoreElements()) {
			String key = en.nextElement();
			Object value = request.getAttribute(key);
	%>
	<li>
	<%= key %> +++++ <%= value %>
	</li>
	<%		
		}
	%>
	</ul>
	
</body>
</html>