<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Login</h4>
	<form action="j_spring_security_check" method="POST">
		<spring:message code="i18n.user"/>:<input type="text" name="j_username"><br>
		<spring:message code="i18n.password"/>:<input type="text" name="j_password"><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>