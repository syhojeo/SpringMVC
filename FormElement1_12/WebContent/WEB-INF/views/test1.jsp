<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test1</h1>
	<form:form action="result" modelAttribute="dataBean">
		<form:hidden path="a1"></form:hidden><br>
		text : <form:input path="a2"></form:input><br>
		password : <form:password path="a3" showPassword="true"></form:password><br>
		textarea : <form:textarea path="a4"></form:textarea><br>
		<form:button disabled="true">확인버튼</form:button>
	</form:form>
</body>
</html>