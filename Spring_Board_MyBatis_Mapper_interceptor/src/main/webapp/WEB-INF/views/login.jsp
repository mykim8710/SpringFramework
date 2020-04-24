<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>login</title>
	</head>
	
	<body>
		<% String path = request.getContextPath(); %>
				
		<c:if test="${member == null}">
			<form action="<%=path %>/member/login" role="form" method="post" autocomplete="off">
				
				<p>
					<label for="userId">아이디</label>
					<input type="text" id="userId" name="username">
				</p>
				
				<p>
					<label for="userPW">패스워드</label>
					<input type="password" id="userPW" name="password">
				</p>
				
				<p><button type="submit">로그인</button></p>
				<p><a href="<%=path %>/member/register">회원가입</a></p>
			</form>
		</c:if>
		
		<c:if test="${message == false}">
			<p style="color:tomato">로그인에 실패했습니다. 아이디 또는 패스워드를 다시 입력해주세요.</p>
		</c:if>
		
		<c:if test="${member != null}">
			<p>${member.username} 님 환영합니다.</p>
			
			<a href="<%=path %>/notice/list">게시판</a>
			<a href="<%=path %>/member/logout">로그아웃</a>
		</c:if>
	</body>
</html>