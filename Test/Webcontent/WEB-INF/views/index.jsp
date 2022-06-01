<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/test.js"></script>
<link href="css/styles.css" rel="stylesheet" />
</head>
<body>
    <h1>Hello Spring MVC Java</h1>
	<img src="image/icon-spring-framework.svg"/> 
	
	<a href='input_data' class=test>input_data</a><br>
	<a href='read_data'>read_data</a><br>
	
	${path }
</body>
</html>