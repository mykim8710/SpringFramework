<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
	<head>
		<title>MainPage</title>
	</head>
	<body>
		<h1>MainPage</h1>
		
		<sec:authorize access="isAnonymous()">
			<p><a href="<c:url value="/login/loginForm"/>">로그인</a></p>
		</sec:authorize>
		
		<sec:authorize access="isAuthenticated()">
		
			<form:form action="${pageContext.request.contextPath}/logout" method="post">
				<input type="submit" value="로그아웃">
			</form:form>
			
			<p><a href="<c:url value="/loginInfo"/>">로그인 정보 확인방법 3가지</a></p>
		</sec:authorize>
		
		<h3>
			<a href="<c:url value="/user/userHome"/>">유저 홈</a>
			<a href="<c:url value="/admin/adminHome"/>">관리자 홈</a>
		</h3>
		
		<P>  The time on the server is ${serverTime}. </P>
	</body>
</html>
