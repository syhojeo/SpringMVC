<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- form custom 태그 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test3</h1>
	<!-- form custom tag 사용 test1과 같은 결과가 나온다 -->
	<form:form modelAttribute="test_user2" action="result">
		이름 : <form:input path="user_name"/><br>
		아이디 : <form:input path="user_id"/><br>
		비밀번호 : <form:password path="user_pw" showPassword="true"/><br>
		우편번호 : <form:input path="user_postcode"/><br>
		주소1 : <form:input path="user_address"/><br>
		주소2 : <form:input path="user_address2"/><br>
		<button type="submit">확인</button>
	</form:form>
</body>
</html>