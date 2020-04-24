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
		<form action="reply" method="post">
			<input type="hidden" name="bGroup" value="${vo.bGroup}">
			<input type="hidden" name="bStep" value="${vo.bStep}">
			<input type="hidden" name="bIndent" value="${vo.bIndent}">
			
			<table width="500" cellpadding="0" cellspacing="0" border="1">
				<tr>
					<td> 글번호 </td>
					<td> ${vo.bId} </td>
				</tr>
				<tr>
					<td> 작성일시 </td>
					<td> ${vo.bDate} </td>
				</tr>				
				<tr>
					<td>작성자</td>
					<td><input type="text" name="bName" size="50"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="bTitle" size="50" value="Re : ${vo.bTitle}"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea name="bContent" rows="30" cols="50">Re : ${vo.bContent}</textarea>
					</td>
				</tr>
				
				<tr >
					<td colspan="2"> <input type="submit" value="답변작성"> &nbsp;&nbsp; <a href="list">글목록</a></td>
				</tr>
			</table>
		</form>	
	</body>
</html>