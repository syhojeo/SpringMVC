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
	<h3>세션 영역에 저장되었습니다</h3>
<%-- 	<h3>sessionBean1.data1 : ${sessionScope.sessionBean1.data1 }</h3> --%>
<%-- 	<h3>sessionBean1.data2 : ${sessionScope.sessionBean1.data2 }</h3> --%>
<%-- 	<h3>sesseionBean2.data1 : ${sessionScope.sessionBean2.data1 }</h3> --%>
<%-- 	<h3>sessionBean2.data2 : ${sessionScope.sessionBean2.data2 }</h3> --%>

	<!-- modelAttribute를 통해 requestScope로도 사용가능하다 -->
	<h3>sessionBean1.data1 : ${requestScope.sessionBean1.data1}</h3>
	<h3>sessionBean1.data2 : ${requestScope.sessionBean1.data2}</h3>
	<h3>sessionBean2.data3 : ${requestScope.sessionBean2.data1}</h3>
	<h3>sessionBean2.data4 : ${requestScope.sessionBean2.data2}</h3>
</body>
</html>