<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test1</h1>
	<!-- 
		커맨드 객체의 값 사용하기
		클래스 이름 앞에를 소문자로 해줘야한다
	 -->
	<h3>data1 : ${requestScope.dataBean.data1}</h3>
	<h3>data2 : ${dataBean.data2}</h3>
</body>
</html>