<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="modifyView" method="post">
			<input type="hidden" name="bId" value="${content.bId}">
			<table border="1">
				<tr>
					<td> 글번호 </td>
					<td> ${content.bId} </td>
				</tr>
				<tr>
					<td> 조회수 </td>
					<td> ${content.bHit} </td>
				</tr>
				<tr>
					<td> 작성자 </td>
					<td> ${content.bName}</td>
				</tr>
				<tr>
					<td> 제목 </td>
					<td> ${content.bTitle}</td>
				</tr>
				<tr>
					<td> 내용 </td>
					<td width="500" height="300"> ${content.bContent}</td>
				</tr>
				<tr >
					<td colspan="2"> 
						<input type="submit" value="수정"> &nbsp;&nbsp; 
						<a href="list">목록보기</a> &nbsp;&nbsp; 
						<a href="deleteContent?bId=${content.bId}">삭제</a> &nbsp;&nbsp; 
						<a href="replyView?bId=${content.bId}">답변</a>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>