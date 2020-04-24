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
		<%String context = request.getContextPath(); %>
		<table border="1">
			<tr>
				<td>글번호</td>
				<td>작성자</td>
				<td>글제목</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
			<c:forEach items="${boardList}" var="vo">
				<tr>
					<td>${vo.bId}</td>
					<td>${vo.bName}</td>
					<td>
						<c:forEach begin="1" end="${vo.bIndent}">└ re:</c:forEach>
						<a href="contentView?bId=${vo.bId}">${vo.bTitle}</a>
					</td>
					<td>${vo.bDate}</td>
					<td>${vo.bHit}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5"> 
					<a href="writeView">새글작성</a>&nbsp;&nbsp;
					<a href="<%=context %>">로그인 페이지</a>&nbsp;&nbsp;
					
					<select name="perPageNum">
						<option value="5">5개씩</option> 
						<option value="10">10개씩</option>
						<option value="20">20개씩</option>
						<option value="30">30개씩</option>
						<option value="50">50개씩</option>
					</select>
					
					
				</td>
			</tr>
		</table>
		<hr>

		<!--페이징 출력 부분-->
		
		<a href="list">처음으로</a>&nbsp;&nbsp;
		
		<c:if test="${pageMaker.prev}">
			<a href="list${pageMaker.makeQuery(pageMaker.startPage - 1) }">«</a>
		</c:if>
		[
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
			<c:out value="${pageMaker.cri.page == idx ? '' : ''}" />
			<a href="list${pageMaker.makeQuery(idx)}">${idx}</a>
		</c:forEach>]
		
		<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			<a href="list${pageMaker.makeQuery(pageMaker.endPage + 1) }">»</a>
		</c:if> 
		
		&nbsp;&nbsp;<a href="#">마지막으로</a>
		
	</body>
</html>