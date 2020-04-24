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
		<table border="1">
			<tr>
				<td>글번호</td>
				<td>작성자</td>
				<td>글제목</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
			<c:forEach items="${list4}" var="vo">
			<tr>
				<td>${vo.bId}</td>
				<td>${vo.bName}</td>
				<td>
					<c:forEach begin="1" end="${vo.bIndent}">└ re:</c:forEach>
					<a href="content_view?bId=${vo.bId}">${vo.bTitle}</a></td>
				<td>${vo.bDate}</td>
				<td>${vo.bHit}</td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="5"> <a href="write_view">새글작성</a> </td>
			</tr>
		</table>
	</body>
</html>