<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>loginOk.jsp</h2>
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>${member.id}</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>${member.pw}</td>
			</tr>
		</table>
		<a href="login">뒤로가기</a>
	</body>
</html>