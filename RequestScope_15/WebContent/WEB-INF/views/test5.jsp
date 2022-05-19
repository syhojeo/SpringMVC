<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test5</h1>
	<!-- bean1 의 필드명만 적어줘도 된다 (getData1()을 안해도 된다) -->
	bean1.data1 : ${requestScope.bean1.data1 } <br>
	bean1.data2 : ${requestScope.bean1.data2 }
</body>
</html>