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
		<form action="modifyContent" method="post">
			<input type="hidden" name="bId" value="${modify.bId}">
			<table width="500" cellpadding="0" cellspacing="0" border="1">
				<tr>
					<td> 글번호 </td>
					<td> ${modify.bId} </td>
				</tr>
				<tr>
					<td> 조회수 </td>
					<td> ${modify.bHit} </td>
				</tr>
				<tr>
					<td> 작성일시 </td>
					<td> ${modify.bDate} </td>
				</tr>
				<tr>
					<td> 작성자 </td>
					<td> ${modify.bName} </td>
				</tr>
				<tr>
					<td> 글제목 </td>
					<td> <input type="text" name="bTitle" size = "50" value="${modify.bTitle}"> </td>
				</tr>
				<tr>
					<td> 내용 </td>
					<td> <textarea name="bContent" rows="10">${modify.bContent}</textarea> </td>
				</tr>
				<tr >
					<td colspan="2"> 
						<input type="submit" value="수정완료"> &nbsp;&nbsp; 
						<a href="boardList">글목록</a>
					</td>
				</tr>
			</table>
		</form>	
	</body>
</html>