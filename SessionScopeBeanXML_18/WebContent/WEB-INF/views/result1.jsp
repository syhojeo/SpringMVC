<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>result1</h1>
	<!--  
	<h3>sessionBean1.data1 : ${sessionScope.sessionBean1.data1}</h3>
	<h3>sessionBean1.data2 : ${sessionScope.sessionBean1.data2}</h3>
	-->
	<h3>sessionBean1.data1 : ${requestScope.sessionBean1.data1}</h3>
	<h3>sessionBean1.data2 : ${requestScope.sessionBean1.data2}</h3>
	
	<!-- 이름을 가지고 저장된 경우 내용 출력 -->
	<h3>sessionBean2.data3 : ${sessionScope.sessionBean2.data3}</h3>
	<h3>sessionBean2.data4 : ${sessionScope.sessionBean2.data4}</h3>
</body>
</html>